package com.action;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class EditorIllustrationAction  extends AnAction {

	/**
	 * Displays a message with information about the current caret.
	 * @param e  Event related to this action
	 */
	@Override
	public void actionPerformed(@NotNull final AnActionEvent e) {
		// Get access to the editor and caret model. update() validated editor's existence.
		final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		final CaretModel caretModel = editor.getCaretModel();
		// Getting the primary caret ensures we get the correct one of a possible many.
		final Caret primaryCaret = caretModel.getPrimaryCaret();
		// Get the caret information
		LogicalPosition logicalPos = primaryCaret.getLogicalPosition();
		VisualPosition visualPos = primaryCaret.getVisualPosition();
		int caretOffset = primaryCaret.getOffset();
		// Build and display the caret report.
		StringBuilder report = new StringBuilder(logicalPos.toString() + "\n");
		report.append(visualPos.toString() + "\n");
		report.append("Offset: " + caretOffset);
		Messages.showInfoMessage(report.toString(), "Caret Parameters Inside The Editor");
	}

	/**
	 * Sets visibility and enables this action menu item if:
	 *   A project is open,
	 *   An editor is active,
	 * @param e  Event related to this action
	 */
	@Override
	public void update(@NotNull final AnActionEvent e) {
		// Get required data keys
		final Project project = e.getProject();
		final Editor editor = e.getData(CommonDataKeys.EDITOR);
		//Set visibility only in case of existing project and editor
		e.getPresentation().setEnabledAndVisible(project != null && editor != null);
	}
}