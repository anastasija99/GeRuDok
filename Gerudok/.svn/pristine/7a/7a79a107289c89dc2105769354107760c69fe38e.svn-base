package events;

import model.Page;

public class DocumentEvent {
	private DocumentEventType type = null;
	private Page page = null;

	public DocumentEvent(DocumentEventType type, Page page) {
		this.type = type;
		this.page = page;
	}
	
	

	public DocumentEventType getType() {
		return type;
	}

	public Page getPage() {
		return page;
	}

	public enum DocumentEventType {
		ADD_PAGE, REMOVE_PAGE, RENAME_DOCUMENT, ADD_PAGE2
	}
}
