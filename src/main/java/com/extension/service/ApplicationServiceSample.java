package com.extension.service;

import com.intellij.openapi.components.ServiceManager;

public class ApplicationServiceSample {
	public static ApplicationServiceSample getInstance() {
		return ServiceManager.getService(ApplicationServiceSample.class);
	}
	public void serviceSayHello() {
		System.out.println("--> I'm [ApplicationServiceSample] : hello....");
	}
}
