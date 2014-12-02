package com.sample.engine.impl.cmd;

import com.sample.engine.foo.Foo;
import com.sample.engine.impl.Command;
import com.sample.engine.impl.CommandContext;
import com.sample.engine.impl.db.FooImpl;
import com.sample.engine.impl.db.FooQueryImpl;

public class DeleteFooCmd extends Command<Void> {

  protected final String fooId;

  public DeleteFooCmd(String fooId) {
    this.fooId = fooId;
  }

  @Override
  public Void execute(CommandContext commandContext) {
    final Foo foo = new FooQueryImpl(commandContext).id(fooId).singleResult();
    if (foo == null)
      throw new IllegalArgumentException("Foo with id '" + fooId + "' does not exist.");

    commandContext.getFooManager().delete((FooImpl) foo);

    return null;
  }
}
