package org.agito.demo.howto.processchoices.cancel;

// @@begin imports

import de.agito.cps.commons.logging.Logger;
import de.agito.cps.ui.vaadin.bpmo.BPMOUIController;
import de.agito.cps.ui.vaadin.bpmo.IBPMOUIControllerContext;
import de.agito.cps.ui.vaadin.bpmo.annotation.Navigation;
import de.agito.cps.ui.vaadin.bpmo.annotation.StyleController;
import de.agito.cps.ui.vaadin.bpmo.enums.NavigationType;
import de.agito.cps.ui.vaadin.bpmo.styles.IFlowStyleController;
import org.agito.demo.howto.processchoices.cancel.CancelBPMO;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOAccess;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOAction;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOLanguage;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOLifecycle;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOProcessActivity;

// @@end

// @@begin head:uicontroller
/**
 * Vaadin UI Controller for CancelBPMO.
 * 
 * @author andreas.weise
 */
// @@end
public class CancelBPMOUIController extends BPMOUIController<CancelBPMOAccess, CancelBPMOAction, CancelBPMOLifecycle, CancelBPMOLanguage, CancelBPMOProcessActivity, CancelBPMO> {

	public CancelBPMOUIController(final IBPMOUIControllerContext context) {
		super(context);
	}

	// @@begin head:init:CancelBPMO
	/**
	 * Hook for node element init of CancelBPMO
	 */
	// @@end
	@Navigation(artifact = "CancelBPMO", type = NavigationType.NODE_ELEMENT_INIT)
	public void cpsInitCancelBPMO(final CancelBPMOAccess bpmoAccess) {
		// @@begin body:init:CancelBPMO

		// @@end
	}

	// @@begin head:destroy:CancelBPMO
	/**
	 * Hook for node element destroy of CancelBPMO
	 */
	// @@end
	@Navigation(artifact = "CancelBPMO", type = NavigationType.NODE_ELEMENT_DESTROY)
	public void cpsDestroyCancelBPMO(final CancelBPMOAccess bpmoAccess) {
		// @@begin body:destroy:CancelBPMO

		// @@end
	}

	// @@begin others

	@StyleController
	public IFlowStyleController styleController;

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(CancelBPMOUIController.class);

	// @@end
}
