package org.agito.bpmo.test;

import org.agito.demo.howto.processchoices.message.MessageBPMO;
import org.agito.demo.howto.processchoices.message.MessageBPMOLifecycle;
import org.agito.demo.howto.processchoices.message.MessageBPMOProcessActivity;
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

public class MessageBPMOTest {

	@Rule
	public BPMOProcessEngineRule bpmoRule = new BPMOProcessEngineRule();

	@Deployment(resources = "org/agito/demo/howto/processchoices/message/MessageProcess.bpmn")
	@BPMODeployment(resources = "org/agito/demo/howto/processchoices/message/MessageBPMO.bpmo")
	@BPMOTestUserId("bob")
	@Test
	public void testMessageBPMONew() {

		// create bpmo
		IBPMO bpmo = bpmoRule.getBpmoEngine().getRuntimeService()
		    .createBPMO(MessageBPMO.$BPMO, MessageBPMOLifecycle.New, "001");

		// start process & complete requester task
		bpmo.startProcess();
		bpmo.claimTaskInstance(MessageBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance();

		// complete approver task with 'Declined' choice.
		bpmo.claimTaskInstance(MessageBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Declined", "Comment for Declined Choice Test");

		// assertion
		ProcessHistory historyItem = bpmoRule.getBpmoEngine().getRuntimeService().createProcessHistoryQuery()
		    .bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid()).processActivityIds(MessageBPMOProcessActivity.Approver)
		    .eventType(ProcessAgentEventType.TASK_CANCEL).singleResult();
		Assert.assertNotNull(historyItem);
		Assert.assertEquals("Comment for Declined Choice Test", historyItem.getCommentText());

		// complete the process
		bpmo.claimTaskInstance(MessageBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance();
		bpmo.claimTaskInstance(MessageBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Approved", null);

		// assertion
		historyItem = bpmoRule.getBpmoEngine().getRuntimeService().createProcessHistoryQuery()
		    .bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid()).eventType(ProcessAgentEventType.PROCESS_END).singleResult();
		Assert.assertNotNull(historyItem);

	}

}