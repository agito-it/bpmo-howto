package org.agito.demo.howto.processchoices.signal;

// @@begin imports

import de.agito.cps.commons.logging.Logger;
import de.agito.cps.core.bpmo.annotations.BPMO;
import de.agito.cps.core.bpmo.api.controller.BPMOController;
import de.agito.cps.core.bpmo.api.controller.IBPMOControllerContext;
import org.agito.demo.howto.processchoices.signal.SignalBPMO;
import org.agito.demo.howto.processchoices.signal.SignalBPMOAccess;
import org.agito.demo.howto.processchoices.signal.SignalBPMOAction;
import org.agito.demo.howto.processchoices.signal.SignalBPMOLanguage;
import org.agito.demo.howto.processchoices.signal.SignalBPMOLifecycle;
import org.agito.demo.howto.processchoices.signal.SignalBPMOProcessActivity;

// @@end

// @@begin head:controller
/**
 * BPMOController for SignalBPMO.
 * 
 * @author andreas.weise
 */
// @@end
@BPMO(id = "SignalBPMO", version = "1.0.0", xml = "org/agito/demo/howto/processchoices/signal/SignalBPMO.bpmo")
public class SignalBPMOController extends BPMOController<SignalBPMOAccess, SignalBPMOAction, SignalBPMOLifecycle, SignalBPMOLanguage, SignalBPMOProcessActivity, SignalBPMO> {

	public SignalBPMOController(final IBPMOControllerContext context) {
		super(context);
	}

	// @@begin others

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(SignalBPMOController.class);

	// @@end
}
