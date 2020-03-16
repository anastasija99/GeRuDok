package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import add.IDraw;
import enums.ActionSelect;
import enums.Draw;
import enums.Handle;
import events.PageEvent;
import events.PageEvent.PageEventType;
import gui.MainFrame;
import model.Page;
import model.PageSlotSelection;
import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.elements.SlotDevice;
import state.ResizeState;
import state.StateManager;
import view.painters.CirclePainter;
import view.painters.Handler;
import view.painters.RectanglePainter;
import view.painters.SlotView;
import view.painters.TrianglePainter;

public class PageView extends JPanel implements Observer, IDraw {

	public static final int PAGE_HEIGHT = 380;
	public static final int PAGE_WIDTH = 300;
	public static final int RECTANGLE = 2;
	public static final int CIRCLE = 1;
	public static final int TRIANGLE = 3;

	private DocumentView docView;
	private Page page;
	private String name;
	private ArrayList<SlotView> slotViews = new ArrayList<SlotView>();
	private StateManager stateManager;
	private Point lastPosition = null;
	Handler handler;
	Rectangle2D selectionRectangle;
	private TextEditor textContent;
	private ImageEditor imgContent;

	public PageView(DocumentView documentView, Page page) {
		this.docView = documentView;
		this.page = page;
		this.name = page.getName();
		selectionRectangle = new Rectangle2D.Double();
		stateManager = new StateManager(this);
		setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
		TitledBorder border = BorderFactory.createTitledBorder(name);
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		PagePanel panel = new PagePanel();
		this.page.addObserver(this);
		this.addMouseListener(panel);
		this.addMouseListener(new MouseController(this));
		this.addMouseMotionListener(new MouseMotionController(this));
		revalidate();
		handler = new Handler();
	}

	public Rectangle2D getSelectionRectangle() {
		return selectionRectangle;
	}

	public void setRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
	}

	public void update2(Object event, ActionSelect a) {
		if (a == ActionSelect.SELECTION || event instanceof SlotDevice) {
			repaint();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!(arg instanceof PageEvent))
			return;

		PageEvent eventObject = (PageEvent) arg;

		if (eventObject.getType() == PageEventType.RENAME_PAGE) {
			this.name = page.getName();
			this.setName(name);

		} else if (eventObject.getType() == PageEventType.DRAW) {
			repaint();

		}
		MainFrame.getInstance().repaint();
		MainFrame.getInstance().revalidate();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

	@Override
	protected void paintComponent(Graphics graph) {

		handler.setG2d((Graphics2D) graph);

		super.paintComponent(graph);
		Graphics2D g = (Graphics2D) graph;

		if (page.getSelectSlot() != null) {
			page.getSlotDevices().remove(page.getSelectSlot());
			page.getSlotDevices().add(page.getSelectSlot());
		}

		for (SlotDevice slotDevice : page.getSlotDevices()) {
			SlotView slPainter = slotDevice.getSlotPainter();
			slPainter.paint(slotDevice, g);
		}

		for (SlotDevice s : page.getSelectedSlots()) {
			SlotView slPainter = s.getSlotPainter();
			s.getSlotPainter().draw();
			g.setPaint(Color.GREEN);
			g.setStroke(s.getStroke());
			g.draw(slPainter.getShape());
			g.setPaint(s.getPaint());
			g.fill(slPainter.getShape());
		}

		if (page.getSelectSlot() != null && stateManager.getState() instanceof ResizeState) {
			for (SlotDevice slotDevice : page.getSelectedSlots()) {
				handler.setSelectedSlot(slotDevice);
				handler.paintHandles();
			}

		}

		g.setColor(Color.RED);
		g.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1f,
				new float[] { 3f, 6f }, 0));
		g.draw(selectionRectangle);
	}

	public DocumentView getDocumentView() {
		return (DocumentView) getParent().getParent().getParent();
	}

	public ArrayList<SlotView> getSlotViews() {
		return slotViews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		TitledBorder border = BorderFactory.createTitledBorder(name);
		border.setTitleColor(Color.BLACK);
		setBorder(border);
	}

	public Page getPage() {
		return page;
	}

	private class MouseMotionController extends MouseMotionAdapter {
		private PageView pageView;

		public MouseMotionController(PageView p) {
			pageView = p;
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			// Page page = ((PageView) event.getComponent()).getPage();
			if (page.getSelectSlot() == null) {
				return;
			}
			Cursor cursor = handler.setMouseCursor((Point2D) event.getPoint());
			if (cursor != null)
				pageView.setCursor(cursor);
			else
				pageView.setCursor(Cursor.getDefaultCursor());

			if (!page.getSelectSlot().getSlotPainter().elementAtPosition(event.getPoint()))
				pageView.setCursor(Cursor.getDefaultCursor());
		}

		@Override
		public void mouseDragged(MouseEvent event) {
			Handle handleForPoint = handler.getPointOfHandle(page.getSelectSlot(), event.getPoint());

			if (handleForPoint != null) {
				stateManager.getState().setHandle(handleForPoint);
				stateManager.getState().mouseDragged(event);
				repaint();

			}
			stateManager.getState().mouseDragged(event);
			repaint();
			/*
			 * if (page.getSelectSlot() != null) {
			 * stateManager.getState().mouseDragged(event); repaint(); }
			 */
		}
	}

	private class MouseController extends MouseAdapter {
		private PageView pageView;

		public MouseController(PageView p) {
			pageView = p;
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// try {
			lastPosition = event.getPoint();
			docView.setPageInFocus(pageView, event);

			if (stateManager == null || stateManager.getState() == null)
				return;
			if (stateManager.getState() instanceof ResizeState) {
				stateManager.getState().setGraphics(pageView.getGraphics());

			}
			stateManager.getState().mousePressed(event);
			pageView.repaint();

			// }
			// catch(NullPointerException e){
			// JOptionPane.showMessageDialog(null, "Select the page", "Error",
			// JOptionPane.ERROR_MESSAGE);
			// }

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			stateManager.getState().mouseReleased(e);
			System.out.println("Klik");
			pageView.repaint();
		}
	}

	public void startRectangleState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setRectangleState();
	}

	public void startTriangleState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setTriangleState();
	}

	public void startCircleState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setCircleState();
	}

	public void startResizeState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setResizeState();
	}

	public void startRotateState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setRotateState();
	}

	public void startMoveState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setMoveState();
	}

	public void startSelectState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setSelectState();
	}

	public void startDeleteState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setDeleteState();
	}

	public void startSelectObjectState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setSelectState();
	}

	public void startContentState() {
		if (stateManager == null) {
			stateManager = new StateManager(this);
		}
		stateManager.setContentState();
	}

	public Point getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point lastPosition) {
		this.lastPosition = lastPosition;
	}

	public void paste() {
		Transferable clipBoardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
		if (clipBoardContent != null && clipBoardContent.isDataFlavorSupported(PageSlotSelection.slotFlavor)) {
			try {

				ArrayList<SlotDevice> tempElements = (ArrayList<SlotDevice>) clipBoardContent
						.getTransferData(PageSlotSelection.slotFlavor);
				for (SlotDevice device : tempElements) {
					if (device instanceof CircleElement) {
						device.setSlotPainter(new CirclePainter(device));
					} else if (device instanceof RectangleElement) {
						device.setSlotPainter(new RectanglePainter(device));
					} else {
						device.setSlotPainter(new TrianglePainter(device));
					}

					page.addElements(device);

				}

			} catch (Exception ex) {
				ex.printStackTrace();

			}
		}
	}

	public TextEditor getTextContent() {
		return textContent;
	}

	public void setTextContent(TextEditor textContent) {
		this.textContent = textContent;
	}

	public ImageEditor getImgContent() {
		return imgContent;
	}

	public void setImgContent(ImageEditor imgContent) {
		this.imgContent = imgContent;
	}

	@Override
	public void updateDraw(Object event, Draw d) {

		if (event instanceof SlotDevice && d == Draw.DRAW) {
			repaint();
		}
		MainFrame.getInstance().revalidate();
		MainFrame.getInstance().repaint();

	}

}
