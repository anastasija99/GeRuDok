package events;

public class PageEvent {
	private PageEventType type = null;

	public PageEvent(PageEventType type) {
		this.type = type;

	}

	public PageEventType getType() {
		return type;
	}

	public enum PageEventType {
		RENAME_PAGE, DRAW
	}
}
