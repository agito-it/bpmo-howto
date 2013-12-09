package org.agito.demo.howto.processchoices.forward;


import de.agito.cps.core.bpmo.api.enums.IProcessActivity;


/**
 * Process Activity Enum for ForwardBPMO.
 *
 * @author andreas.weise
 */
public enum ForwardBPMOProcessActivity implements IProcessActivity {

	$DRAFT,
	Requester,
	Approver;

}

