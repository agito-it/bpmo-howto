package org.agito.demo.howto.processchoices.message;

// @@begin imports

import de.agito.cps.commons.logging.Logger;
import de.agito.cps.ui.vaadin.bpmo.BPMOUIController;
import de.agito.cps.ui.vaadin.bpmo.IBPMOUIControllerContext;
import de.agito.cps.ui.vaadin.bpmo.annotation.Navigation;
import de.agito.cps.ui.vaadin.bpmo.annotation.StyleController;
import de.agito.cps.ui.vaadin.bpmo.enums.NavigationType;
import de.agito.cps.ui.vaadin.bpmo.styles.IFlowStyleController;
import org.agito.demo.howto.processchoices.message.MessageBPMO;
import org.agito.demo.howto.processchoices.message.MessageBPMOAccess;
import org.agito.demo.howto.processchoices.message.MessageBPMOAction;
import org.agito.demo.howto.processchoices.message.MessageBPMOLanguage;
import org.agito.demo.howto.processchoices.message.MessageBPMOLifecycle;
import org.agito.demo.howto.processchoices.message.MessageBPMOProcessActivity;

// @@end

// @@begin head:uicontroller
/**
 * Vaadin UI Controller for MessageBPMO.
 * 
 * @author andreas.weise
 */
// @@end
public class MessageBPMOUIController extends BPMOUIController<MessageBPMOAccess, MessageBPMOAction, MessageBPMOLifecycle, MessageBPMOLanguage, MessageBPMOProcessActivity, MessageBPMO> {

	public MessageBPMOUIController(final IBPMOUIControllerContext context) {
		super(context);
	}

	// @@begin head:init:MessageBPMO
	/**
	 * Hook for node element init of MessageBPMO
	 */
	// @@end
	@Navigation(artifact = "MessageBPMO", type = NavigationType.NODE_ELEMENT_INIT)
	public void cpsInitMessageBPMO(final MessageBPMOAccess bpmoAccess) {
		// @@begin body:init:MessageBPMO

		// @@end
	}

	// @@begin head:destroy:MessageBPMO
	/**
	 * Hook for node element destroy of MessageBPMO
	 */
	// @@end
	@Navigation(artifact = "MessageBPMO", type = NavigationType.NODE_ELEMENT_DESTROY)
	public void cpsDestroyMessageBPMO(final MessageBPMOAccess bpmoAccess) {
		// @@begin body:destroy:MessageBPMO

		// @@end
	}

	// @@begin others

	@StyleController
	public IFlowStyleController styleController;

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(MessageBPMOUIController.class);

	// @@end
}
