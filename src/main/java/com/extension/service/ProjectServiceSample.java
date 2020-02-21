package com.extension.service;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;

import org.jetbrains.annotations.NotNull;

public class ProjectServiceSample {
	private Project project;
	public ProjectServiceSample(Project project) {
		this.project = project;
	}

	public static ProjectServiceSample getInstance(@NotNull Project project) {
		return ServiceManager.getService(project, ProjectServiceSample.class);
	}

	public void serviceSayHello() {
		String projectName = project.getName();
		System.out.println("--> I'm [ProjectServiceSample] [" + projectName + "] : hello....");
	}
}
