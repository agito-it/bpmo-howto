package com.sample.engine.rest.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class DefaultApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();

		classes.addAll(MyEngineRestResources.getResourceClasses());
		classes.addAll(MyEngineRestResources.getConfigurationClasses());

		return classes;
	}
}
