package org.agito.demo.howto.processchoices.forward;


import de.agito.cps.core.bpmo.api.enums.ILifecycle;


/**
 * Lifecycle Enum for ForwardBPMO.
 *
 * @author andreas.weise
 */
public enum ForwardBPMOLifecycle implements ILifecycle {

	New(false, "BPMOHowtoProcessChoices_ForwardProcess");

	private ForwardBPMOLifecycle(boolean supportsOriginalValue, String processDefinitionId) { this.supportsOriginalValue = supportsOriginalValue; this.processDefinitionId = processDefinitionId; }
	private boolean supportsOriginalValue;
	private String processDefinitionId;
	public boolean supportsOriginalValue() { return supportsOriginalValue; }
	public String getProcessDefinitionId() { return processDefinitionId; }

}

