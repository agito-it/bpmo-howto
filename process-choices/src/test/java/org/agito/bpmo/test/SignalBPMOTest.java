package org.agito.bpmo.test;

import org.agito.demo.howto.processchoices.signal.SignalBPMO;
import org.agito.demo.howto.processchoices.signal.SignalBPMOLifecycle;
import org.agito.demo.howto.processchoices.signal.SignalBPMOProcessActivity;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import de.agito.cps.core.bpmo.IBPMO;
import de.agito.cps.core.engine.runtime.ProcessHistory;
import de.agito.cps.core.process.spi.eventing.ProcessAgentEventType;
import de.agito.cps.process.camunda.test.BPMODeployment;
import de.agito.cps.process.camunda.test.BPMOTestUserId;
import de.agito.cps.test.camunda.BPMOProcessEngineRule;

public class SignalBPMOTest {

	@Rule
	public BPMOProcessEngineRule bpmoRule = new BPMOProcessEngineRule();

	@Deployment(resources = "org/agito/demo/howto/processchoices/signal/SignalProcess.bpmn")
	@BPMODeployment(resources = "org/agito/demo/howto/processchoices/signal/SignalBPMO.bpmo")
	@BPMOTestUserId("bob")
	@Test
	public void testSignalBPMONew() {

		// create bpmo
		IBPMO bpmo = bpmoRule.getBpmoEngine().getRuntimeService()
		    .createBPMO(SignalBPMO.$BPMO, SignalBPMOLifecycle.New, "001");

		// start process & complete requester task
		bpmo.startProcess();
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance();

		// complete approver task with 'Declined' choice.
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Declined", "Comment for Declined Choice Test");

		// assertion
		ProcessHistory historyItem = bpmoRule.getBpmoEngine().getRuntimeService().createProcessHistoryQuery()
		    .bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid()).processActivityIds(SignalBPMOProcessActivity.Approver)
		    .eventType(ProcessAgentEventType.TASK_CANCEL).singleResult();
		Assert.assertNotNull(historyItem);
		Assert.assertEquals("Comment for Declined Choice Test", historyItem.getCommentText());

		// complete the process
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance();
		bpmo.claimTaskInstance(SignalBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Approved", null);

		// assertion
		historyItem = bpmoRule.getBpmoEngine().getRuntimeService().createProcessHistoryQuery()
		    .bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid()).eventType(ProcessAgentEventType.PROCESS_END).singleResult();
		Assert.assertNotNull(historyItem);

	}

}