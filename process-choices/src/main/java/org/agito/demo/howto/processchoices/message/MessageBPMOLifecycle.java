package org.agito.demo.howto.processchoices.message;


import de.agito.cps.core.bpmo.api.enums.ILifecycle;


/**
 * Lifecycle Enum for MessageBPMO.
 *
 * @author andreas.weise
 */
public enum MessageBPMOLifecycle implements ILifecycle {

	New(false, "MessageProcess");

	private MessageBPMOLifecycle(boolean supportsOriginalValue, String processDefinitionId) { this.supportsOriginalValue = supportsOriginalValue; this.processDefinitionId = processDefinitionId; }
	private boolean supportsOriginalValue;
	private String processDefinitionId;
	public boolean supportsOriginalValue() { return supportsOriginalValue; }
	public String getProcessDefinitionId() { return processDefinitionId; }

}

