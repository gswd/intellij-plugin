package com.psi;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;

public class PsiNavigationDemoAction extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent anActionEvent) {
		Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);
		PsiFile psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE);
		if (editor == null || psiFile == null) return;
		int offset = editor.getCaretModel().getOffset();

		final StringBuilder infoBuilder = new StringBuilder();
		PsiElement element = psiFile.findElementAt(offset);
		infoBuilder.append("Element at caret: ").append(element).append("\n");

		Messages.showMessageDialog(anActionEvent.getProject(), infoBuilder.toString(), "PSI Info", null);
	}

	@Override
	public void update(AnActionEvent e) {
		Editor editor = e.getData(CommonDataKeys.EDITOR);
		PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
		e.getPresentation().setEnabled(editor != null && psiFile != null);
	}
}
