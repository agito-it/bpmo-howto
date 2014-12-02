package com.sample.engine.impl;

import com.sample.engine.FooService;
import com.sample.engine.MyEngine;

import de.agito.cps.commons.base.engine.AbstractBaseEngine;

public class MyEngineImpl extends AbstractBaseEngine<MyEngineConfiguration, CommandContext> implements MyEngine {

  public MyEngineImpl(MyEngineConfiguration engineConfiguration) {
    super(engineConfiguration);
  }

  @Override
  public FooService getFooService() {
    return engineConfiguration.getFooService();
  }

}
