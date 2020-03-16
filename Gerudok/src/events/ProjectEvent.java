package events;

import model.Document;
import model.Page;

public class ProjectEvent {
	private ProjectEventType type = null;
	private Document document = null;
	private Page p = null;

	public ProjectEvent(ProjectEventType type, Document document) {
		this.type = type;
		this.document = document;
	}
	
	public ProjectEvent(ProjectEventType type, Page p) {
		this.type = type;
		this.p = p;
	}

	public ProjectEventType getType() {
		return type;
	}

	public Document getDocument() {
		return document;
	}

	public enum ProjectEventType {
		ADD_DOCUMENT, REMOVE_DOCUMENT, RENAME_PROJECT, IMPORT_DOCUMENT
	}
}
