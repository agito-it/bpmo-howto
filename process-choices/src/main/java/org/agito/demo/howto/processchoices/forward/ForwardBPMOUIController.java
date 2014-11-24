package org.agito.demo.howto.processchoices.forward;

// @@begin imports

import de.agito.cps.commons.logging.Logger;
import de.agito.cps.ui.vaadin.bpmo.BPMOUIController;
import de.agito.cps.ui.vaadin.bpmo.IBPMOUIControllerContext;
import de.agito.cps.ui.vaadin.bpmo.annotation.Navigation;
import de.agito.cps.ui.vaadin.bpmo.annotation.StyleController;
import de.agito.cps.ui.vaadin.bpmo.enums.NavigationType;
import de.agito.cps.ui.vaadin.bpmo.styles.IFlowStyleController;
import org.agito.demo.howto.processchoices.forward.ForwardBPMO;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOAccess;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOAction;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOLanguage;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOLifecycle;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOProcessActivity;

// @@end

// @@begin head:uicontroller
/**
 * Vaadin UI Controller for ForwardBPMO.
 * 
 * @author andreas.weise
 */
// @@end
public class ForwardBPMOUIController extends BPMOUIController<ForwardBPMOAccess, ForwardBPMOAction, ForwardBPMOLifecycle, ForwardBPMOLanguage, ForwardBPMOProcessActivity, ForwardBPMO> {

	public ForwardBPMOUIController(final IBPMOUIControllerContext context) {
		super(context);
	}

	// @@begin head:init:ForwardBPMO
	/**
	 * Hook for node element init of ForwardBPMO
	 */
	// @@end
	@Navigation(artifact = "ForwardBPMO", type = NavigationType.NODE_ELEMENT_INIT)
	public void cpsInitForwardBPMO(final ForwardBPMOAccess bpmoAccess) {
		// @@begin body:init:ForwardBPMO

		// @@end
	}

	// @@begin head:destroy:ForwardBPMO
	/**
	 * Hook for node element destroy of ForwardBPMO
	 */
	// @@end
	@Navigation(artifact = "ForwardBPMO", type = NavigationType.NODE_ELEMENT_DESTROY)
	public void cpsDestroyForwardBPMO(final ForwardBPMOAccess bpmoAccess) {
		// @@begin body:destroy:ForwardBPMO

		// @@end
	}

	// @@begin others

	@StyleController
	public IFlowStyleController styleController;

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(ForwardBPMOUIController.class);

	// @@end
}
