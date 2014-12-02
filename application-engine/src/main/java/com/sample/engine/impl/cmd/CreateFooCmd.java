package com.sample.engine.impl.cmd;

import com.sample.engine.foo.Foo;
import com.sample.engine.impl.Command;
import com.sample.engine.impl.CommandContext;
import com.sample.engine.impl.db.FooImpl;

public class CreateFooCmd extends Command<Foo> {

  protected final String name;

  public CreateFooCmd(String name) {
    this.name = name;
  }

  @Override
  public Foo execute(CommandContext commandContext) {
    return new FooImpl(name);
  }

}
