package com.sample.engine.rest.impl;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.jaxrs.JsonMappingExceptionMapper;
import org.codehaus.jackson.jaxrs.JsonParseExceptionMapper;

import de.agito.cps.commons.rest.exception.EngineExceptionHandler;
import de.agito.cps.commons.rest.exception.RestExceptionHandler;
import de.agito.cps.commons.rest.mapper.JacksonConfigurator;

public class MyEngineRestResources {

	private static final Set<Class<?>> RESOURCE_CLASSES = new HashSet<Class<?>>();

	private static final Set<Class<?>> CONFIGURATION_CLASSES = new HashSet<Class<?>>();

	static {
		RESOURCE_CLASSES.add(FooRestServiceImpl.class);

		CONFIGURATION_CLASSES.add(JacksonConfigurator.class);
		CONFIGURATION_CLASSES.add(JacksonJsonProvider.class);
		CONFIGURATION_CLASSES.add(JsonMappingExceptionMapper.class);
		CONFIGURATION_CLASSES.add(JsonParseExceptionMapper.class);
		CONFIGURATION_CLASSES.add(EngineExceptionHandler.class);
		CONFIGURATION_CLASSES.add(RestExceptionHandler.class);
	}

	/**
	 * Returns a set containing all resource classes.
	 * 
	 * @return a set of resource classes.
	 */
	public static Set<Class<?>> getResourceClasses() {
		return RESOURCE_CLASSES;
	}

	/**
	 * Returns a set containing all provider / mapper / config classes used in the
	 * default setup of the REST api.
	 * 
	 * @return a set of provider / mapper / config classes.
	 */
	public static Set<Class<?>> getConfigurationClasses() {
		return CONFIGURATION_CLASSES;
	}

}
