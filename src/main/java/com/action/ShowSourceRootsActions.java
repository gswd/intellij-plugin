package com.action;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

public class ShowSourceRootsActions extends AnAction {

	@Override
	public void actionPerformed(@NotNull final AnActionEvent event) {
		Project project = event.getProject();
		if (project == null) return;
		String projectName = project.getName();
		StringBuilder sourceRootsList = new StringBuilder();
		VirtualFile[] vFiles = ProjectRootManager.getInstance(project).getContentSourceRoots();
		for (VirtualFile file : vFiles) {
			sourceRootsList.append(file.getUrl()).append("\n");
		}

		sourceRootsList.append("---------\n");

		VirtualFile[] contentRoots = ProjectRootManager.getInstance(project).getContentRoots();
		for (VirtualFile file : contentRoots) {
			sourceRootsList.append(file.getUrl()).append("\n");
		}
		Messages.showInfoMessage("Source roots for the [" + projectName + "] plugin:\n" + sourceRootsList,
			"Project Properties");
	}

	@Override
	public void update(@NotNull final AnActionEvent event) {
		boolean visibility = event.getProject() != null;
		event.getPresentation().setEnabled(visibility);
		event.getPresentation().setVisible(visibility);
	}
}
