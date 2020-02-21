package com.listener;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;

public class MyVfsListener implements BulkFileListener {

	@Override
	public void before(@NotNull List<? extends VFileEvent> events) {
		System.out.println("[MyVfsListener] [before]");
	}

	@Override
	public void after(@NotNull List<? extends VFileEvent> events) {
		System.out.println("[MyVfsListener] [after]");
		for (VFileEvent event : events) {
			String filePath = event.getPath();
			System.out.println("[listen change]--> " + filePath);
		}
	}
}
