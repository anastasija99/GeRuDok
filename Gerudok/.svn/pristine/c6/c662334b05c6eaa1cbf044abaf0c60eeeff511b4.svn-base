package gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import actions.manager.ActionManager;
import errorHandling.ErrorHandler;
import errorHandling.ErrorHandlerView;
import model.Page;
import model.Workspace;
import tree.listener.JTreeController;
import tree.view.TreeCellRendered;
import tree.view.TreeEditor;
import tree.view.TreePopUp;
import view.WorkspaceView;

public class MainFrame extends JFrame implements ClipboardOwner {

	private static MainFrame instance = null;

	private JTree tree = null;
	private WorkspaceView workspaceView = null;
	private MenuBar menuBar = null;
	private Workspace workspace;
	private ActionManager actionManager = new ActionManager();
	private ToolBar toolBar = null;
	private SlotToolbarGerudok slotToolBar = null;
	private ErrorHandlerView errorHandlerView;
	private Page activePage;
	private JSplitPane splitPane;
	private JPanel panel;
	


	private Clipboard clipboard = new Clipboard("Gerudok clipboard");

	private MainFrame() {
		super();
		errorHandlerView = new ErrorHandlerView();
		ErrorHandler.getInstance().addObserver(errorHandlerView);

	}

	private void initMainFrameGerudok() {

		setTitle("WeGotSolutions");

		// podesavanje velicine i pozicije prozora
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(1400, 800);
		setLocationRelativeTo(null);
		addWindowListener(new NewWindowListener());

		// Postavljanje ikonice
		setIconImage(new ImageIcon("images/puzzle.png").getImage());
		setVisible(true);
		
		panel = new JPanel();

		menuBar = new MenuBar();
		setJMenuBar(menuBar);

		toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		slotToolBar = new SlotToolbarGerudok();
		add(slotToolBar, BorderLayout.EAST);

		workspaceView = new WorkspaceView();
		tree = initializeTree(workspaceView);
		JScrollPane sp = new JScrollPane(tree);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp, workspaceView);
		JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane, panel);
		splitPane.setDividerLocation(300);
		sp2.setDividerLocation(1000);
		add(sp2, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		splitPane.setDividerLocation(0.2);
	

	}

	public SlotToolbarGerudok getSlotToolBar() {
		return slotToolBar;
	}

	public void setSlotToolBar(SlotToolbarGerudok slotToolBar) {
		this.slotToolBar = slotToolBar;
	}

	public void setToolBar(ToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public void setWorkspace(Workspace workspace) {
		if (workspace == null)
			return;
		this.workspace = workspace;
	}

	private JTree initializeTree(WorkspaceView workspaceView) {
		Workspace root = Workspace.getInstance();
		root.addObserver(workspaceView);
		setWorkspaceModel(root);
		JTree tree = new JTree(root);
		tree.setModel(new DefaultTreeModel(root));
		tree.addTreeSelectionListener(new JTreeController());
		tree.setCellEditor(new TreeEditor(tree, new DefaultTreeCellRenderer()));
		tree.setCellRenderer(new TreeCellRendered());
		tree.setComponentPopupMenu(new TreePopUp());
		tree.setEditable(true);

		return tree;
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setTree(JTree tree) {
		this.tree = tree;

	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initMainFrameGerudok();
		}

		return instance;
	}

	public JTree getTree() {
		return tree;
	}

	public WorkspaceView getWorkspaceView() {
		return workspaceView;
	}

	public MenuBar getMenu() {
		return menuBar;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	public Workspace getWorkspaceModel() {
		return workspace;
	}

	public void setWorkspaceModel(Workspace ws) {
		this.workspace = ws;
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}
	
	public Page getActivePage() {
		return activePage;
	}
	
	public void setActivePage(Page page) {
		this.activePage = page;
	}
	
	public Clipboard getClipboard() {
		return clipboard;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}
	

}
