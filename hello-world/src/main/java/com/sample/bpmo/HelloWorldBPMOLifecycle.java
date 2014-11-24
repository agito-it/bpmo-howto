package com.sample.bpmo;


import de.agito.cps.core.bpmo.api.enums.ILifecycle;


/**
 * Lifecycle Enum for HelloWorldBPMO.
 *
 * @author andreas.weise
 */
public enum HelloWorldBPMOLifecycle implements ILifecycle {

	New(false, "HelloWorldProcess");

	private HelloWorldBPMOLifecycle(boolean supportsOriginalValue, String processDefinitionId) { this.supportsOriginalValue = supportsOriginalValue; this.processDefinitionId = processDefinitionId; }
	private boolean supportsOriginalValue;
	private String processDefinitionId;
	public boolean supportsOriginalValue() { return supportsOriginalValue; }
	public String getProcessDefinitionId() { return processDefinitionId; }

}

