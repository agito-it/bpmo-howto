package com.sample.engine.impl.cmd;

import com.sample.engine.foo.Foo;
import com.sample.engine.impl.Command;
import com.sample.engine.impl.CommandContext;
import com.sample.engine.impl.db.FooImpl;

public class SaveFooCmd extends Command<Foo> {

  protected final FooImpl foo;

  public SaveFooCmd(Foo foo) {
    this.foo = (FooImpl) foo;
  }

  @Override
  public Foo execute(CommandContext commandContext) {

    if (foo.getRevision() == 0)
      commandContext.getFooManager().insert(foo);
    else
      commandContext.getFooManager().update(foo);

    return foo;
  }

}
