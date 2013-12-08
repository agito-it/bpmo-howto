package org.agito.demo.howto.processchoices.signal;


import de.agito.cps.core.bpmo.api.enums.ILifecycle;


/**
 * Lifecycle Enum for SignalBPMO.
 *
 * @author andreas.weise
 */
public enum SignalBPMOLifecycle implements ILifecycle {

	New(false, "BPMOHowtoProcessChoices_SignalProcess");

	private SignalBPMOLifecycle(boolean supportsOriginalValue, String processDefinitionId) { this.supportsOriginalValue = supportsOriginalValue; this.processDefinitionId = processDefinitionId; }
	private boolean supportsOriginalValue;
	private String processDefinitionId;
	public boolean supportsOriginalValue() { return supportsOriginalValue; }
	public String getProcessDefinitionId() { return processDefinitionId; }

}

