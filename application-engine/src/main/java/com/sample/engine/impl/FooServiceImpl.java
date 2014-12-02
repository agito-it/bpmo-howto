package com.sample.engine.impl;

import com.sample.engine.FooService;
import com.sample.engine.foo.Foo;
import com.sample.engine.foo.FooQuery;
import com.sample.engine.impl.cmd.CreateFooCmd;
import com.sample.engine.impl.cmd.DeleteFooCmd;
import com.sample.engine.impl.cmd.SaveFooCmd;
import com.sample.engine.impl.db.FooQueryImpl;

import de.agito.cps.commons.base.engine.AbstractBaseService;

public class FooServiceImpl extends AbstractBaseService<MyEngineConfiguration, CommandContext> implements FooService {

  @Override
  public Foo createFoo(String name) {
    return executeCommand(new CreateFooCmd(name));
  }

  @Override
  public Foo saveFoo(Foo foo) {
    return executeCommand(new SaveFooCmd(foo));
  }

  @Override
  public void deleteFoo(String fooId) {
    executeCommand(new DeleteFooCmd(fooId));
  }

  @Override
  public FooQuery createFooQuery() {
    return getQuery(FooQueryImpl.class);
  }

}
