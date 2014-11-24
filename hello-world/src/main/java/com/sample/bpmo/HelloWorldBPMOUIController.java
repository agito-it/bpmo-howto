package com.sample.bpmo;

// @@begin imports

import com.sample.bpmo.HelloWorldBPMO;
import com.sample.bpmo.HelloWorldBPMOAccess;
import com.sample.bpmo.HelloWorldBPMOAction;
import com.sample.bpmo.HelloWorldBPMOLanguage;
import com.sample.bpmo.HelloWorldBPMOLifecycle;
import com.sample.bpmo.HelloWorldBPMOProcessActivity;
import de.agito.cps.commons.logging.Logger;
import de.agito.cps.ui.vaadin.bpmo.BPMOUIController;
import de.agito.cps.ui.vaadin.bpmo.IBPMOUIControllerContext;
import de.agito.cps.ui.vaadin.bpmo.annotation.Navigation;
import de.agito.cps.ui.vaadin.bpmo.annotation.StyleController;
import de.agito.cps.ui.vaadin.bpmo.enums.NavigationType;
import de.agito.cps.ui.vaadin.bpmo.styles.IFlowStyleController;

// @@end

// @@begin head:uicontroller
/**
 * Vaadin UI Controller for HelloWorldBPMO.
 * 
 * @author andreas.weise
 */
// @@end
public class HelloWorldBPMOUIController extends BPMOUIController<HelloWorldBPMOAccess, HelloWorldBPMOAction, HelloWorldBPMOLifecycle, HelloWorldBPMOLanguage, HelloWorldBPMOProcessActivity, HelloWorldBPMO> {

	public HelloWorldBPMOUIController(final IBPMOUIControllerContext context) {
		super(context);
	}

	// @@begin head:init:HelloWorldBPMO
	/**
	 * Hook for node element init of HelloWorldBPMO
	 */
	// @@end
	@Navigation(artifact = "HelloWorldBPMO", type = NavigationType.NODE_ELEMENT_INIT)
	public void cpsInitHelloWorldBPMO(final HelloWorldBPMOAccess bpmoAccess) {
		// @@begin body:init:HelloWorldBPMO

		// @@end
	}

	// @@begin head:destroy:HelloWorldBPMO
	/**
	 * Hook for node element destroy of HelloWorldBPMO
	 */
	// @@end
	@Navigation(artifact = "HelloWorldBPMO", type = NavigationType.NODE_ELEMENT_DESTROY)
	public void cpsDestroyHelloWorldBPMO(final HelloWorldBPMOAccess bpmoAccess) {
		// @@begin body:destroy:HelloWorldBPMO

		// @@end
	}

	// @@begin others

	@StyleController
	public IFlowStyleController styleController;

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(HelloWorldBPMOUIController.class);

	// @@end
}
