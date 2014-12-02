package com.sample.engine.rest.impl;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.sample.engine.MyEngine;
import com.sample.engine.foo.Foo;
import com.sample.engine.rest.FooDto;
import com.sample.engine.rest.FooResource;

import de.agito.cps.commons.rest.exception.InvalidRequestException;

public class FooResourceImpl implements FooResource {

  protected final MyEngine engine;
  protected final String fooId;

  public FooResourceImpl(MyEngine engine, String fooId) {
    this.engine = engine;
    this.fooId = fooId;
  }

  @Override
  public FooDto getFoo(UriInfo context) {
    return FooDto.fromFoo(getFoo());
  }

  @Override
  public void deleteFoo() {
    engine.getFooService().deleteFoo(getFoo().getId());
  }

  @Override
  public void updateFoo(FooDto fooDto) {
    Foo foo = getFoo();
    FooDto.update(fooDto, foo);
    engine.getFooService().saveFoo(foo);
  }

  protected Foo getFoo() {
    Foo foo = engine.getFooService().createFooQuery().id(fooId).singleResult();

    if (foo == null) {
      throw new InvalidRequestException(Status.NOT_FOUND, "Foo with id '" + fooId + "' does not exist.");
    }
    return foo;
  }
}
