package org.agito.demo.howto.processchoices.forward;

// @@begin imports

import de.agito.cps.commons.logging.Logger;
import de.agito.cps.core.bpmo.annotations.BPMO;
import de.agito.cps.core.bpmo.api.controller.BPMOController;
import de.agito.cps.core.bpmo.api.controller.IBPMOControllerContext;
import org.agito.demo.howto.processchoices.forward.ForwardBPMO;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOAccess;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOAction;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOLanguage;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOLifecycle;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOProcessActivity;

// @@end

// @@begin head:controller
/**
 * BPMOController for ForwardBPMO.
 * 
 * @author andreas.weise
 */
// @@end
@BPMO(id = "ForwardBPMO", version = "1.0.0", xml = "org/agito/demo/howto/processchoices/forward/ForwardBPMO.bpmo")
public class ForwardBPMOController extends BPMOController<ForwardBPMOAccess, ForwardBPMOAction, ForwardBPMOLifecycle, ForwardBPMOLanguage, ForwardBPMOProcessActivity, ForwardBPMO> {

	public ForwardBPMOController(final IBPMOControllerContext context) {
		super(context);
	}

	// @@begin others

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(ForwardBPMOController.class);

	// @@end
}
