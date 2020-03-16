package events;

import model.Project;

public class WorkspaceEvent {
	private WorkspaceEventType type = null;
	private Project project = null;

	public WorkspaceEvent(WorkspaceEventType type, Project project) {
		this.type = type;
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public WorkspaceEventType getType() {
		return type;
	}

	public enum WorkspaceEventType {
		ADD_PROJECT, REMOVE_PROJECT, OPEN_PROJECT
	}
}
