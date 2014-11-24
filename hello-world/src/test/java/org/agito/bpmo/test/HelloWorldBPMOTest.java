package org.agito.bpmo.test;

import static org.junit.Assert.assertEquals;

import com.sample.bpmo.HelloWorldBPMO;
import com.sample.bpmo.HelloWorldBPMOAccess;
import com.sample.bpmo.HelloWorldBPMOLifecycle;
import com.sample.bpmo.HelloWorldBPMOProcessActivity;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import de.agito.cps.core.bpmo.IBPMO;
import de.agito.cps.process.camunda.CamundaProcessAgent;
import de.agito.cps.process.camunda.test.BPMODeployment;
import de.agito.cps.process.camunda.test.BPMOTestUserId;
import de.agito.cps.test.camunda.BPMOProcessEngineRule;

public class HelloWorldBPMOTest {

	@Rule
	public BPMOProcessEngineRule bpmoRule = new BPMOProcessEngineRule();

	@Deployment(resources = "HelloWorldProcess.bpmn")
	@BPMODeployment(resources = "com/sample/bpmo/HelloWorldBPMO.bpmo")
	@BPMOTestUserId("bob")
	@Test
	public void testHelloWorldBPMONew() {

		// create bpmo
		IBPMO bpmo = bpmoRule.getBpmoEngine().getRuntimeService()
		    .createBPMO(HelloWorldBPMO.$BPMO, HelloWorldBPMOLifecycle.New, "001");
		HelloWorldBPMOAccess helloWorldBPMOAccess = new HelloWorldBPMOAccess(bpmo.getBPMOData());

		bpmo.startProcess();

		bpmo.claimTaskInstance(HelloWorldBPMOProcessActivity.Requester);

		bpmo.completeTaskInstance();

	}

}