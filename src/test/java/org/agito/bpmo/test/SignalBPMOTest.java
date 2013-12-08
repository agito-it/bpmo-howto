package org.agito.bpmo.test;

import org.agito.demo.howto.processchoices.signal.SignalBPMO;
import org.agito.demo.howto.processchoices.signal.SignalBPMOAccess;
import org.agito.demo.howto.processchoices.signal.SignalBPMOLifecycle;
import org.agito.demo.howto.processchoices.signal.SignalBPMOProcessActivity;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import de.agito.cps.core.bpmo.IBPMO;
import de.agito.cps.core.engine.runtime.ProcessHistory;
import de.agito.cps.core.process.spi.eventing.ProcessAgentEventType;
import de.agito.cps.core.test.BPMOTestRule;
import de.agito.cps.core.test.annotations.BPMOTestUserId;

public class SignalBPMOTest {

	@Rule
	public BPMOTestRule bpmoRule = BPMOTestRule.init();

	@BPMOTestUserId("bob")
	@Test
	public void testSignalBPMONew() {

		// create bpmo
		IBPMO bpmo = bpmoRule.getRuntimeService().createBPMO(SignalBPMO.$BPMO, SignalBPMOLifecycle.New, "001");
		SignalBPMOAccess signalBPMOAccess = new SignalBPMOAccess(bpmo.getBPMOData());

		// start process & complete requester task
		bpmo.startProcess();
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance();
		
		// complete approver task with 'Declined' choice.
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Declined", "Comment for Declined Choice Test");
		
		// assertion
		ProcessHistory historyItem = bpmoRule.getRuntimeService()
				.createProcessHistoryQuery()
				.bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid())
				.processActivityIds(SignalBPMOProcessActivity.Approver).eventType(ProcessAgentEventType.TASK_CANCEL).singleResult();
		Assert.assertNotNull(historyItem);
		Assert.assertEquals("Comment for Declined Choice Test", historyItem.getCommentText());
		
		// complete the process
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance();		
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Approved", null);
		
		// assertion
		historyItem = bpmoRule.getRuntimeService()
				.createProcessHistoryQuery()
				.bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid())
				.eventType(ProcessAgentEventType.PROCESS_END).singleResult();
		Assert.assertNotNull(historyItem);
	}

}