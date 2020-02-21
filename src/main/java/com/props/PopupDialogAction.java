package com.props;

import com.extension.service.ApplicationServiceSample;
import com.extension.service.ProjectServiceSample;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;

public class PopupDialogAction extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent event) {
		System.out.println("------------ actionPerformed -------------");
		ExtServiceSample(event);
		anActionSample(event);

	}

	private void anActionSample(AnActionEvent event) {
		// Using the event, create and show a dialog
		Project currentProject = event.getProject();
		StringBuffer dlgMsg = new StringBuffer(event.getPresentation().getText() + " Selected!");
		String dlgTitle = event.getPresentation().getDescription();
		// If an element is selected in the editor, add info about it.
		Navigatable nav = event.getData(CommonDataKeys.NAVIGATABLE);
		if (nav != null) {
			dlgMsg.append(String.format("\nSelected Element: %s", nav.toString()));
		}
		Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon());
	}

	private void ExtServiceSample(AnActionEvent event) {
		ApplicationServiceSample applicationServiceSample = ServiceManager.getService(ApplicationServiceSample.class);
		if(null != applicationServiceSample) applicationServiceSample.serviceSayHello();

		Project project = event.getProject();
		if(null != project) project.getService(ProjectServiceSample.class).serviceSayHello();
	}

	@Override
	public void update(AnActionEvent e) {
		System.out.println("------------ update -------------");
		// Set the availability based on whether a project is open
		Project project = e.getProject();
		e.getPresentation().setEnabledAndVisible(project != null);
	}
}
