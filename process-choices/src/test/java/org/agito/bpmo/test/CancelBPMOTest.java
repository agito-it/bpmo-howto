package org.agito.bpmo.test;

import org.agito.demo.howto.processchoices.cancel.CancelBPMO;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOLifecycle;
import org.agito.demo.howto.processchoices.cancel.CancelBPMOProcessActivity;
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

public class CancelBPMOTest {

	@Rule
	public BPMOProcessEngineRule bpmoRule = new BPMOProcessEngineRule();

	@Deployment(resources = "org/agito/demo/howto/processchoices/cancel/CancelProcess.bpmn")
	@BPMODeployment(resources = "org/agito/demo/howto/processchoices/cancel/CancelBPMO.bpmo")
	@BPMOTestUserId("bob")
	@Test
	public void testCancelBPMONew() {

		// create bpmo
		IBPMO bpmo = bpmoRule.getBpmoEngine().getRuntimeService()
		    .createBPMO(CancelBPMO.$BPMO, CancelBPMOLifecycle.New, "001");

		// start process
		bpmo.startProcess();
		bpmo.claimTaskInstance(CancelBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Decline", "Rework");

		// complete task with choice "Cancel"
		bpmo.claimTaskInstance(CancelBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance("Cancel", "Comment for Cancel Choice Test");

		ProcessHistory historyItem = bpmoRule.getBpmoEngine().getRuntimeService().createProcessHistoryQuery()
		    .bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid()).eventType(ProcessAgentEventType.PROCESS_CANCEL).singleResult();
		Assert.assertNotNull(historyItem);
		Assert.assertEquals("Comment for Cancel Choice Test", historyItem.getCommentText());
	}

}