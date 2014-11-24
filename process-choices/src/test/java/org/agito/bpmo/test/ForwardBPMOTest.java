package org.agito.bpmo.test;

import org.agito.demo.howto.processchoices.forward.ForwardBPMO;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOLifecycle;
import org.agito.demo.howto.processchoices.forward.ForwardBPMOProcessActivity;
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

public class ForwardBPMOTest {

	@Rule
	public BPMOProcessEngineRule bpmoRule = new BPMOProcessEngineRule();

	@Deployment(resources = "org/agito/demo/howto/processchoices/forward/ForwardProcess.bpmn")
	@BPMODeployment(resources = "org/agito/demo/howto/processchoices/forward/ForwardBPMO.bpmo")
	@BPMOTestUserId("bob")
	@Test
	public void testForwardBPMONew() {

		// create bpmo
		IBPMO bpmo = bpmoRule.getBpmoEngine().getRuntimeService()
		    .createBPMO(ForwardBPMO.$BPMO, ForwardBPMOLifecycle.New, "001");

		bpmo.startProcess();

		// complete approver task using choice 'Decline'.
		bpmo.claimTaskInstance(ForwardBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Decline", "Rework");

		// complete requester task
		bpmo.claimTaskInstance(ForwardBPMOProcessActivity.Requester);
		bpmo.completeTaskInstance();

		// complete approver task using choice 'Approve'.
		bpmo.claimTaskInstance(ForwardBPMOProcessActivity.Approver);
		bpmo.completeTaskInstance("Approve", null);

		// assertion
		ProcessHistory historyItem = bpmoRule.getBpmoEngine().getRuntimeService().createProcessHistoryQuery()
		    .bpmoUuid(bpmo.getBPMOHeader().getBPMOUuid()).eventType(ProcessAgentEventType.PROCESS_END).singleResult();
		Assert.assertNotNull(historyItem);

	}

}