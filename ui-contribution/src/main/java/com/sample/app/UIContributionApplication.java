package com.sample.app;

import java.util.concurrent.Callable;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.PreUndeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationExecutionException;
import org.camunda.bpm.application.impl.ServletProcessApplication;

import de.agito.cps.core.application.BPMOApplication;
import de.agito.cps.core.application.BPMOApplicationInterface;
import de.agito.cps.core.engine.app.ApplicationContext;
import de.agito.cps.process.camunda.app.BPMOApplicationHelper;

@BPMOApplication
@ProcessApplication("BPMOHowtoUIContributionApplication")
public class UIContributionApplication extends ServletProcessApplication implements BPMOApplicationInterface {

  private ApplicationContext applicationContext;

  @PostDeploy
  public void deployBPMO() {
    BPMOApplicationHelper.INSTANCE.deploy(this);
  }

  @PreUndeploy
  public void undeployBPMO() {
    BPMOApplicationHelper.INSTANCE.undeploy(this);
  }

  @Override
  public <T> T execute(Callable<T> callable) throws ProcessApplicationExecutionException {
    try {
      BPMOApplicationHelper.INSTANCE.preExecute(this);
      return super.execute(callable);
    } finally {
      BPMOApplicationHelper.INSTANCE.postExecute(this);
    }
  }

  @Override
  public ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

}
