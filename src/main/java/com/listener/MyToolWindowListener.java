package com.listener;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ex.ToolWindowManagerListener;

public class MyToolWindowListener implements ToolWindowManagerListener {

	private Project project;

	public MyToolWindowListener() {
		System.out.println("[MyToolWindowListener()] [construct]");
	}

	public MyToolWindowListener(Project project) {
		this.project = project;
		System.out.println("[MyToolWindowListener(project)] [construct]");
	}

	@Override
	public void stateChanged() {
		System.out.println("[MyToolWindowListener] [stateChanged]");

	}
}
