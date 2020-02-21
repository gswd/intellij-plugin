package com.treeStructure;

import com.intellij.ide.projectView.*;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.*;

import java.util.*;

/**
 * 只显示目录和普通文本
 */
public class TextOnlyTreeStructureProvider implements TreeStructureProvider {
  @NotNull
  @Override
  public Collection<AbstractTreeNode> modify(@NotNull AbstractTreeNode parent,
                                             @NotNull Collection<AbstractTreeNode> children,
                                             ViewSettings settings) {
    ArrayList<AbstractTreeNode> nodes = new ArrayList<AbstractTreeNode>();
    for (AbstractTreeNode child : children) {
      if (child instanceof PsiFileNode) {
        VirtualFile file = ((PsiFileNode) child).getVirtualFile();
        if (file != null && !file.isDirectory() && !(file.getFileType() instanceof PlainTextFileType)) {
          // TODO continue;
        }
      }
      nodes.add(child);
    }
    return nodes;
  }

  @Nullable
  @Override
  public Object getData(@NotNull Collection<AbstractTreeNode> selected, @NotNull String dataId) {
    return null;
  }
}