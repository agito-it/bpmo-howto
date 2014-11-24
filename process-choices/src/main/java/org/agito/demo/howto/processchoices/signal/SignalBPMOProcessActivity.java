package org.agito.demo.howto.processchoices.signal;


import de.agito.cps.core.bpmo.api.enums.IProcessActivity;


/**
 * Process Activity Enum for SignalBPMO.
 *
 * @author andreas.weise
 */
public enum SignalBPMOProcessActivity implements IProcessActivity {

	$DRAFT,
	Requester,
	Approver;

}

