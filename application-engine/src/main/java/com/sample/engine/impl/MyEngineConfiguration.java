package com.sample.engine.impl;

import com.sample.engine.impl.db.FooManager;

import de.agito.cps.commons.base.engine.AbstractBaseEngine;
import de.agito.cps.commons.base.engine.AbstractBaseEngineConfiguration;
import de.agito.cps.commons.base.engine.execution.AbstractBaseCommandContextFactory;
import de.agito.cps.core.application.engine.AbstractApplicationEngineConfiguration;

public class MyEngineConfiguration extends
    AbstractApplicationEngineConfiguration<MyEngineConfiguration, CommandContext> {

  protected FooServiceImpl fooService;

  @Override
  public AbstractBaseEngine<MyEngineConfiguration, CommandContext> buildEngine(
      AbstractBaseEngineConfiguration<?, ?> coreEngineConfiguration) {
    init(coreEngineConfiguration);
    return new MyEngineImpl(this);
  }

  @Override
  protected AbstractBaseCommandContextFactory<MyEngineConfiguration, CommandContext> createDefaultCommandContextFactory() {
    return new CommandContextFactory();
  }

  @Override
  protected void init(AbstractBaseEngineConfiguration<?, ?> coreEngineConfiguration) {
    super.init(coreEngineConfiguration);

    initServices();
  }

  @Override
  protected void initEntityManagers() {
    super.initEntityManagers();
    entityManagers.add(FooManager.class);
  }

  protected void initServices() {
    fooService = new FooServiceImpl();

    initService(fooService);
  }

  public FooServiceImpl getFooService() {
    return fooService;
  }
}
