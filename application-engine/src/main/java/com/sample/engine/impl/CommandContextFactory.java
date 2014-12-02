package com.sample.engine.impl;

import de.agito.cps.commons.base.engine.execution.AbstractBaseCommandContext;
import de.agito.cps.commons.base.engine.execution.AbstractBaseCommandContextFactory;
import de.agito.cps.commons.base.engine.execution.BaseCommand;

public class CommandContextFactory extends AbstractBaseCommandContextFactory<MyEngineConfiguration, CommandContext> {

  @Override
  public AbstractBaseCommandContext<MyEngineConfiguration, CommandContext> createCommandContext(
      BaseCommand<CommandContext, ?> command) {
    return new CommandContext(command, engineConfiguration);
  }

}
