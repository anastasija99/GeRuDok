package model;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import commadns.CommandManager;
import events.PageEvent;
import events.PageEvent.PageEventType;
import gui.MainFrame;
import model.elements.Slot;
import model.elements.SlotDevice;

public class Page extends Observable implements MutableTreeNode, Serializable, Observer {

	private static int count = 0;
	private Document parent = null;
	private String name = null;
	private boolean pageModified;
	private ArrayList<SlotDevice> slotDevices;
	protected ArrayList<Slot> slots = new ArrayList<Slot>();
	private ArrayList<SlotDevice> selectedSlots = new ArrayList<SlotDevice>();
	private transient SlotDevice selectSlot = null;
	protected ArrayList<SlotDevice> pageElements = new ArrayList<SlotDevice>();
	protected ArrayList<SlotDevice> selectedElements = new ArrayList<SlotDevice>();
	private transient CommandManager commandManager;
	private PageSlotSelection pageSelectionModel;

	
	public Page(Document parent, String name) {
		super();
		this.parent = parent;
		addObserver(parent);
		slotDevices = new ArrayList<SlotDevice>();
		commandManager = new CommandManager();
		this.name = name;
	}

	public CommandManager getCommandManager() {
		if (commandManager == null)
			commandManager = new CommandManager();
		return commandManager;
	}

	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	public ArrayList<SlotDevice> getSelectedSlots() {
		return selectedSlots;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers(new PageEvent(PageEventType.RENAME_PAGE));
	}

	public String toString() {
		String indicator = pageModified ? "*" : "";
		return indicator + name + "";
	}

	public boolean isPageModified() {
		return pageModified;
	}

	public void setPageModified(boolean pageModified) {
		this.pageModified = pageModified;
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public Enumeration children() {
		return null;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		return 0;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!this.pageModified) {
			this.setPageModified(true);
		}
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(MutableTreeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserObject(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers(Object arg) {
		setChanged();
		super.notifyObservers(arg);
	}

	public void addElements(SlotDevice slot) {
		slotDevices.add(slot);
		notifyObservers(PageEventType.DRAW);

	}

	public void removeElements(SlotDevice slot) {
		slotDevices.remove(slot);
		notifyObservers(PageEventType.DRAW);

	}

	private void notifyObservers(PageEventType draw) {
		setChanged();
		super.notifyObservers(new PageEvent(draw));

	}

	public ArrayList<SlotDevice> getSlotDevices() {
		return slotDevices;
	}

	public SlotDevice getSelectSlot() {
		return selectSlot;
	}

	public void setSelectSlot(SlotDevice selectSlot) {
		this.selectSlot = selectSlot;
	}

	public boolean isElementSelected(SlotDevice device) {
		return selectedSlots.contains(device);
	}

	public void selectAllElements(Rectangle2D recectangle) {
		for (SlotDevice slot : slotDevices) {
			if (recectangle.intersects(slot.getPoint().getX(), slot.getPoint().getY(), slot.getDimension().getWidth(),
					slot.getDimension().getHeight())) {
				if (!isElementSelected(slot))
					selectedSlots.add(slot);
			} else if (isElementSelected(slot))
				selectedSlots.remove(slot);
		}

	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Page.count = count;
	}

	public int getSlotCount() {
		return slots.size();
	}

	public Slot getDeviceAt(int i) {
		return slots.get(i);
	}

	public PageSlotSelection getPageSelectionModel() {
		return pageSelectionModel;
	}

	public void setPageSelectionModel(PageSlotSelection pageSelectionModel) {
		this.pageSelectionModel = pageSelectionModel;
	}

	public int getElement(Slot element) {
		for (int i = 0; i < slots.size(); i++) {
			if (slots.get(i).equals(element))
				return i;
		}
		return -1;
	}

}
