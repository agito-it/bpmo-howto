package org.agito.demo.howto.processchoices.message;

// @@begin imports

import de.agito.cps.commons.logging.Logger;
import de.agito.cps.core.bpmo.annotations.BPMO;
import de.agito.cps.core.bpmo.api.controller.BPMOController;
import de.agito.cps.core.bpmo.api.controller.IBPMOControllerContext;
import org.agito.demo.howto.processchoices.message.MessageBPMO;
import org.agito.demo.howto.processchoices.message.MessageBPMOAccess;
import org.agito.demo.howto.processchoices.message.MessageBPMOAction;
import org.agito.demo.howto.processchoices.message.MessageBPMOLanguage;
import org.agito.demo.howto.processchoices.message.MessageBPMOLifecycle;
import org.agito.demo.howto.processchoices.message.MessageBPMOProcessActivity;

// @@end

// @@begin head:controller
/**
 * BPMOController for MessageBPMO.
 * 
 * @author andreas.weise
 */
// @@end
@BPMO(id = "MessageBPMO", version = "1.0.0", xml = "org/agito/demo/howto/processchoices/message/MessageBPMO.bpmo")
public class MessageBPMOController extends BPMOController<MessageBPMOAccess, MessageBPMOAction, MessageBPMOLifecycle, MessageBPMOLanguage, MessageBPMOProcessActivity, MessageBPMO> {

	public MessageBPMOController(final IBPMOControllerContext context) {
		super(context);
	}

	// @@begin others

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(MessageBPMOController.class);

	// @@end
}
