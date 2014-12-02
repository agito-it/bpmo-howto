package com.sample.engine.impl;

import com.sample.engine.impl.db.FooManager;

import de.agito.cps.commons.base.engine.execution.AbstractBaseCommandContext;
import de.agito.cps.commons.base.engine.execution.BaseCommand;
import de.agito.cps.commons.base.engine.execution.BaseContext;

public class CommandContext extends AbstractBaseCommandContext<MyEngineConfiguration, CommandContext> {

  public CommandContext(BaseCommand<CommandContext, ?> command, MyEngineConfiguration engineConfiguration) {
    super(command, engineConfiguration);
  }

  public FooManager getFooManager() {
    return getSession(FooManager.class);
  }

  public static CommandContext getCurrent() {
    return BaseContext.getCommandContext(CommandContext.class);
  }

}
