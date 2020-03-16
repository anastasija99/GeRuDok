package state;

import java.io.Serializable;

import view.PageView;

public class StateManager implements Serializable {

	private State state = null;

	private RectangleState rectangleState;
	private TriangleState triangleState;
	private CircleState circleState;
	private ResizeState resizeState;
	private RotateState rotateState;
	private MoveState moveState;
	private SelectState selectState;
	private DeleteState deleteState;
	private ContentState contentState;

	public StateManager(PageView pageView) {
		rectangleState = new RectangleState(pageView);
		triangleState = new TriangleState(pageView);
		circleState = new CircleState(pageView);
		resizeState = new ResizeState(pageView);
		rotateState = new RotateState(pageView);
		moveState = new MoveState(pageView);
		selectState = new SelectState(pageView);
		deleteState = new DeleteState(pageView);
		contentState = new ContentState(pageView);
		state = selectState;
	}

	public State getState() {
		return state;
	}

	public void setContentState() {
		this.state = contentState;
	}

	public void setRectangleState() {
		state = rectangleState;
	}

	public void setTriangleState() {
		state = triangleState;
	}

	public void setCircleState() {
		state = circleState;
	}

	public void setResizeState() {
		state = resizeState;
	}

	public void setRotateState() {
		state = rotateState;
	}

	public void setSelectState() {
		state = selectState;
	}

	public void setMoveState() {
		state = moveState;
	}

	public void setDeleteState() {
		state = deleteState;
	}

}