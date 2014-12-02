package com.sample.engine.impl;

import de.agito.cps.commons.base.engine.AbstractBaseQuery;
import de.agito.cps.commons.base.engine.execution.CommandExecutor;
import de.agito.cps.commons.base.engine.query.Query;

public abstract class AbstractQuery<Q extends Query<?, ?>, T> extends
    AbstractBaseQuery<MyEngineConfiguration, CommandContext, Q, T> {

  private static final long serialVersionUID = -2923706969231980511L;

  public AbstractQuery() {
    super();
  }

  public AbstractQuery(CommandContext commandContext) {
    super(commandContext);
  }

  public AbstractQuery(CommandExecutor<CommandContext> commandExecutor) {
    super(commandExecutor);
  }

}
