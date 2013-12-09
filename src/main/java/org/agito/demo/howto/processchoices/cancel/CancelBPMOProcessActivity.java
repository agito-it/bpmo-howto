package org.agito.demo.howto.processchoices.cancel;


import de.agito.cps.core.bpmo.api.enums.IProcessActivity;


/**
 * Process Activity Enum for CancelBPMO.
 *
 * @author andreas.weise
 */
public enum CancelBPMOProcessActivity implements IProcessActivity {

	$DRAFT,
	Requester,
	Approver;

}

