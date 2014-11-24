package com.sample.bpmo;

// @@begin imports

import com.sample.bpmo.HelloWorldBPMO;
import com.sample.bpmo.HelloWorldBPMOAccess;
import com.sample.bpmo.HelloWorldBPMOAction;
import com.sample.bpmo.HelloWorldBPMOLanguage;
import com.sample.bpmo.HelloWorldBPMOLifecycle;
import com.sample.bpmo.HelloWorldBPMOProcessActivity;
import de.agito.cps.commons.logging.Logger;
import de.agito.cps.core.bpmo.annotations.BPMO;
import de.agito.cps.core.bpmo.api.controller.BPMOController;
import de.agito.cps.core.bpmo.api.controller.IBPMOControllerContext;
import java.util.Arrays;
import java.util.Map;

// @@end

// @@begin head:controller
/**
 * BPMOController for HelloWorldBPMO.
 * 
 * @author andreas.weise
 */
// @@end
@BPMO(id = "HelloWorldBPMO", version = "1.0.0", xml = "com/sample/bpmo/HelloWorldBPMO.bpmo")
public class HelloWorldBPMOController extends BPMOController<HelloWorldBPMOAccess, HelloWorldBPMOAction, HelloWorldBPMOLifecycle, HelloWorldBPMOLanguage, HelloWorldBPMOProcessActivity, HelloWorldBPMO> {

	public HelloWorldBPMOController(final IBPMOControllerContext context) {
		super(context);
	}

	// @@begin others

	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(HelloWorldBPMOController.class);

	@Override
	public Object cpsExecuteBPMOAction(HelloWorldBPMOAccess bpmoAccess, HelloWorldBPMOAction action,
	    Map<String, Object> parameters) {
		switch (action) {
		case MyAction:
			return "Value";
		default:
			break;
		}
		return super.cpsExecuteBPMOAction(bpmoAccess, action, parameters);
	}

	// @@end
}
