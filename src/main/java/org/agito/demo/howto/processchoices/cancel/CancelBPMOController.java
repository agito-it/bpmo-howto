package org.agito.demo.howto.processchoices.cancel;

// @@begin imports

import de.agito.cps.core.annotations.BPMO;
import de.agito.cps.core.bpmo.api.controller.BPMOController;
import de.agito.cps.core.bpmo.api.controller.IBPMOControllerContext;
import de.agito.cps.core.logger.Logger;
import org.agito.demo.howto.processchoices.cancel.CancelBPMO;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOAccess;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOAction;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOLanguage;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOLifecycle;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOProcessActivity;

// @@end

// @@begin head:controller
/**
 * BPMOController for CancelBPMO.
 * 
 * @author andreas.weise
 */
// @@end
@BPMO(id = "CancelBPMO", version = "1.0.0", xml = "org/agito/demo/howto/processchoices/cancel/CancelBPMO.bpmo")
public class CancelBPMOController extends BPMOController<CancelBPMOAccess, CancelBPMOAction, CancelBPMOLifecycle, CancelBPMOLanguage, CancelBPMOProcessActivity, CancelBPMO> {

	public CancelBPMOController(final IBPMOControllerContext context) {
		super(context);
	}

	// @@begin others

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(CancelBPMOController.class);

	// @@end
}
