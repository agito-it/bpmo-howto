package org.agito.demo.howto.processchoices.signal;

// @@begin imports

import de.agito.cps.commons.logging.Logger;
import de.agito.cps.ui.vaadin.bpmo.BPMOUIController;
import de.agito.cps.ui.vaadin.bpmo.IBPMOUIControllerContext;
import de.agito.cps.ui.vaadin.bpmo.annotation.Navigation;
import de.agito.cps.ui.vaadin.bpmo.annotation.StyleController;
import de.agito.cps.ui.vaadin.bpmo.enums.NavigationType;
import de.agito.cps.ui.vaadin.bpmo.styles.IFlowStyleController;
import org.agito.demo.howto.processchoices.signal.SignalBPMO;
import org.agito.demo.howto.processchoices.signal.SignalBPMOAccess;
import org.agito.demo.howto.processchoices.signal.SignalBPMOAction;
import org.agito.demo.howto.processchoices.signal.SignalBPMOLanguage;
import org.agito.demo.howto.processchoices.signal.SignalBPMOLifecycle;
import org.agito.demo.howto.processchoices.signal.SignalBPMOProcessActivity;

// @@end

// @@begin head:uicontroller
/**
 * Vaadin UI Controller for SignalBPMO.
 * 
 * @author andreas.weise
 */
// @@end
public class SignalBPMOUIController extends BPMOUIController<SignalBPMOAccess, SignalBPMOAction, SignalBPMOLifecycle, SignalBPMOLanguage, SignalBPMOProcessActivity, SignalBPMO> {

	public SignalBPMOUIController(final IBPMOUIControllerContext context) {
		super(context);
	}

	// @@begin head:init:SignalBPMO
	/**
	 * Hook for node element init of SignalBPMO
	 */
	// @@end
	@Navigation(artifact = "SignalBPMO", type = NavigationType.NODE_ELEMENT_INIT)
	public void cpsInitSignalBPMO(final SignalBPMOAccess bpmoAccess) {
		// @@begin body:init:SignalBPMO

		// @@end
	}

	// @@begin head:destroy:SignalBPMO
	/**
	 * Hook for node element destroy of SignalBPMO
	 */
	// @@end
	@Navigation(artifact = "SignalBPMO", type = NavigationType.NODE_ELEMENT_DESTROY)
	public void cpsDestroySignalBPMO(final SignalBPMOAccess bpmoAccess) {
		// @@begin body:destroy:SignalBPMO

		// @@end
	}

	// @@begin others

	@StyleController
	public IFlowStyleController styleController;

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(SignalBPMOUIController.class);

	// @@end
}
