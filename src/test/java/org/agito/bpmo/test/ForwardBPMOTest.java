package org.agito.bpmo.test;

import junit.framework.Assert;

import org.agito.demo.howto.processchoices.forward.ForwardBPMO;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOAccess;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOLifecycle;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOProcessActivity;
import org.junit.Rule;
import org.junit.Test;

import de.agito.cps.core.bpmo.IBPMO;
import de.agito.cps.core.engine.runtime.ProcessHistory;
import de.agito.cps.core.process.spi.eventing.ProcessAgentEventType;
import de.agito.cps.core.test.BPMOTestRule;
import de.agito.cps.core.test.annotations.BPMOTestUserId;

public class ForwardBPMOTest {

	@Rule
	public BPMOTestRule bpmoRule = BPMOTestRule.init();

	@BPMOTestUserId("bob")
	@Test
	public void testForwardBPMONew() {

		// create bpmo
		IBPMO bpmo = bpmoRule.getRuntimeService().createBPMO(ForwardBPMO.$BPMO,
				ForwardBPMOLifecycle.New, "001");
		ForwardBPMOAccess forwardBPMOAccess = new ForwardBPMOAccess(bpmo.getBPMOData());
		bpmo.startProcess();
		bpmo.claimTaskInstance(ForwardBPMOProcessActivity.Requester);

		// complete task using a choice.
		bpmo.completeTaskInstance("Complete", null);

		// assertion
		ProcessHistory historyItem = bpmoRule.getRuntimeService()
				.createProcessHistoryQuery()
				.bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid())
				.eventType(ProcessAgentEventType.PROCESS_END).singleResult();
		Assert.assertNotNull(historyItem);

	}

}