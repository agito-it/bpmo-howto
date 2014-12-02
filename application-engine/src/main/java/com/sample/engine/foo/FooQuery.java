package com.sample.engine.foo;

import de.agito.cps.commons.base.engine.query.Query;

/**
 * Fluent sample query for {@link Foo foos}.
 * 
 * @author agito
 *
 */
public interface FooQuery extends Query<FooQuery, Foo> {

  public FooQuery id(String id);

  public FooQuery name(String name);

  public FooQuery value(String value);

}
