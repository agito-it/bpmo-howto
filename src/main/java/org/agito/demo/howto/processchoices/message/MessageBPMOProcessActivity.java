package org.agito.demo.howto.processchoices.message;


import de.agito.cps.core.bpmo.api.enums.IProcessActivity;


/**
 * Process Activity Enum for MessageBPMO.
 *
 * @author andreas.weise
 */
public enum MessageBPMOProcessActivity implements IProcessActivity {

	$DRAFT,
	Requester,
	Approver;

}

