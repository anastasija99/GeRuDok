package actions.manager;

import actions.AboutAction;
import actions.CircleAction;
import actions.CloseAction;
import actions.CloseAllAction;
import actions.CopyAction;
import actions.CutAction;
import actions.DeleteNode;
import actions.DeleteSlotAction;
import actions.DisplayProject;
import actions.MoveAction;
import actions.NewAction;
import actions.OpenProjectAction;
import actions.PasteAction;
import actions.QuitAction;
import actions.RectangleAction;
import actions.RedoAction;
import actions.RenameNode;
import actions.ResizeAction;
import actions.RotateAction;
import actions.SaveAsProjectAction;
import actions.SaveProjectAction;
import actions.SaveWorkspaceAction;
import actions.SelectObjectAction;
import actions.SelectionAction;
import actions.ShareDocumentsAction;
import actions.SwitchWorkspaceAction;
import actions.TextAction;
import actions.TriangleAction;
import actions.UndoAction;

public class ActionManager {

	private AboutAction about;

	private DeleteNode deletenode;
	private DisplayProject displayproject;
	private OpenProjectAction openproject;
	private RenameNode renamenode;
	private SaveAsProjectAction saveas;
	private SaveProjectAction save;
	private QuitAction quit;
	private CircleAction circleAction;
	private TriangleAction triangleAction;
	private RectangleAction rectangleAction;
	private CloseAction closeAction;
	private CloseAllAction closeAllAction;
	private NewAction newAction;
	private SaveWorkspaceAction saveWsAction;
	private ResizeAction resizeAction;
	private RotateAction rotateAction;
	private SwitchWorkspaceAction switchWs;
	private UndoAction undoAction;
	private RedoAction redoAction;
	private MoveAction moveAction;
	private SelectionAction selectAction;
	private CutAction cutAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private DeleteSlotAction deleteSlotAction;
	private SelectObjectAction selectObjectAction;
	private ShareDocumentsAction shareDocuments;
	private DeleteSlotAction deleteSlot;
	private TextAction contentAction;

	private static ActionManager instance = null;

	public ActionManager() {
		about = new AboutAction(AbstractActionIcon.small);
		deletenode = new DeleteNode(AbstractActionIcon.small);
		displayproject = new DisplayProject();
		openproject = new OpenProjectAction(AbstractActionIcon.small);
		renamenode = new RenameNode(AbstractActionIcon.small);
		saveas = new SaveAsProjectAction(AbstractActionIcon.small);
		save = new SaveProjectAction(AbstractActionIcon.small);
		quit = new QuitAction(AbstractActionIcon.small);
		circleAction = new CircleAction((AbstractActionIcon.small));
		rectangleAction = new RectangleAction((AbstractActionIcon.small));
		triangleAction = new TriangleAction((AbstractActionIcon.small));
		closeAction = new CloseAction((AbstractActionIcon.small));
		closeAllAction = new CloseAllAction((AbstractActionIcon.small));
		newAction = new NewAction((AbstractActionIcon.small));
		saveWsAction = new SaveWorkspaceAction((AbstractActionIcon.small));
		resizeAction = new ResizeAction((AbstractActionIcon.small));
		rotateAction = new RotateAction((AbstractActionIcon.small));
		moveAction = new MoveAction((AbstractActionIcon.small));
		selectAction = new SelectionAction((AbstractActionIcon.small));
		redoAction = new RedoAction((AbstractActionIcon.small));
		undoAction = new UndoAction((AbstractActionIcon.small));
		cutAction = new CutAction((AbstractActionIcon.small));
		copyAction = new CopyAction((AbstractActionIcon.small));
		pasteAction = new PasteAction((AbstractActionIcon.small));
		deleteSlotAction = new DeleteSlotAction((AbstractActionIcon.small));
		selectObjectAction = new SelectObjectAction((AbstractActionIcon.small));
		shareDocuments = new ShareDocumentsAction();
		deleteSlot = new DeleteSlotAction((AbstractActionIcon.small));
		contentAction = new TextAction();
		setSwitchWs(new SwitchWorkspaceAction());
		setUndoAction(new UndoAction((AbstractActionIcon.small)));
		

	}

	public AboutAction getAbout() {
		return about;
	}

	public DeleteNode getDeletenode() {
		return deletenode;
	}

	public DisplayProject getDisplayproject() {
		return displayproject;
	}

	public OpenProjectAction getOpenproject() {
		return openproject;
	}

	public RenameNode getRenamenode() {
		return renamenode;
	}

	public SaveAsProjectAction getSaveas() {
		return saveas;
	}

	public SaveProjectAction getSave() {
		return save;
	}

	public QuitAction getQuitaction() {
		return quit;
	}

	public static ActionManager getInstance() {
		if (instance == null)
			instance = new ActionManager();

		return instance;
	}

	public CircleAction getCircleAction() {
		return circleAction;
	}

	public void setCircleAction(CircleAction circleAction) {
		this.circleAction = circleAction;
	}

	public TriangleAction getTriangleAction() {
		return triangleAction;
	}

	public void setTriangleAction(TriangleAction triangleAction) {
		this.triangleAction = triangleAction;
	}

	public RectangleAction getRectangleAction() {
		return rectangleAction;
	}

	public void setRectangleAction(RectangleAction rectangleAction) {
		this.rectangleAction = rectangleAction;
	}

	public CloseAction getCloseAction() {
		return closeAction;
	}

	public void setCloseAction(CloseAction closeAction) {
		this.closeAction = closeAction;
	}

	public CloseAllAction getCloseAllAction() {
		return closeAllAction;
	}

	public void setCloseAllAction(CloseAllAction closeAllAction) {
		this.closeAllAction = closeAllAction;
	}

	public NewAction getNewAction() {
		return newAction;
	}

	public void setNewAction(NewAction newAction) {
		this.newAction = newAction;
	}

	public SaveWorkspaceAction getSaveWsAction() {
		return saveWsAction;
	}

	public void setSaveWsAction(SaveWorkspaceAction saveWsAction) {
		this.saveWsAction = saveWsAction;
	}

	public ResizeAction getResizeAction() {
		return resizeAction;
	}

	public void setResizeAction(ResizeAction resizeAction) {
		this.resizeAction = resizeAction;
	}

	public RotateAction getRotateAction() {
		return rotateAction;
	}

	public void setRotateAction(RotateAction rotateAction) {
		this.rotateAction = rotateAction;
	}

	public SwitchWorkspaceAction getSwitchWs() {
		return switchWs;
	}

	public void setSwitchWs(SwitchWorkspaceAction switchWs) {
		this.switchWs = switchWs;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}

	public MoveAction getMoveAction() {
		return moveAction;
	}

	public void setMoveAction(MoveAction moveAction) {
		this.moveAction = moveAction;
	}

	public SelectionAction getSelectAction() {
		return selectAction;
	}

	public void setSelectAction(SelectionAction selectAction) {
		this.selectAction = selectAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}

	public CutAction getCutAction() {
		return cutAction;
	}

	public void setCutAction(CutAction cutAction) {
		this.cutAction = cutAction;
	}

	public CopyAction getCopyAction() {
		return copyAction;
	}

	public void setCopyAction(CopyAction copyAction) {
		this.copyAction = copyAction;
	}

	public PasteAction getPasteAction() {
		return pasteAction;
	}

	public void setPasteAction(PasteAction pasteAction) {
		this.pasteAction = pasteAction;
	}

	public DeleteSlotAction getDeleteSlotAction() {
		return deleteSlotAction;
	}

	public void setDeleteSlotAction(DeleteSlotAction deleteSlotAction) {
		this.deleteSlotAction = deleteSlotAction;
	}

	public QuitAction getQuit() {
		return quit;
	}

	public SelectObjectAction getSelectObjectAction() {
		return selectObjectAction;
	}

	public void setSelectObjectAction(SelectObjectAction selectObjectAction) {
		this.selectObjectAction = selectObjectAction;
	}

	public void setRenamenode(RenameNode renamenode) {
		this.renamenode = renamenode;
	}

	public ShareDocumentsAction getShareDocuments() {
		return shareDocuments;
	}

	public void setShareDocuments(ShareDocumentsAction shareDocuments) {
		this.shareDocuments = shareDocuments;
	}

	public DeleteSlotAction getDeleteSlot() {
		return deleteSlot;
	}

	public void setDeleteSlot(DeleteSlotAction deleteSlot) {
		this.deleteSlot = deleteSlot;
	}

	public TextAction getContentAction() {
		return contentAction;
	}

	public void setContentAction(TextAction contentAction) {
		this.contentAction = contentAction;
	}
	
	
	
	
}
