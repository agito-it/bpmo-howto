package org.agito.demo.howto.processchoices.cancel;


import de.agito.cps.core.bpmo.api.enums.ILifecycle;


/**
 * Lifecycle Enum for CancelBPMO.
 *
 * @author andreas.weise
 */
public enum CancelBPMOLifecycle implements ILifecycle {

	New(false, "BPMOHowto_CancelProcess");

	private CancelBPMOLifecycle(boolean supportsOriginalValue, String processDefinitionId) { this.supportsOriginalValue = supportsOriginalValue; this.processDefinitionId = processDefinitionId; }
	private boolean supportsOriginalValue;
	private String processDefinitionId;
	public boolean supportsOriginalValue() { return supportsOriginalValue; }
	public String getProcessDefinitionId() { return processDefinitionId; }

}

