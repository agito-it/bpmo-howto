package com.sample.engine;

import com.sample.engine.foo.Foo;
import com.sample.engine.foo.FooQuery;

/**
 * A sample service on my engine.
 * 
 * @author agito
 *
 */
public interface FooService {

  /** create a new transient foo */
  Foo createFoo(String name);

  /** persist a foo */
  Foo saveFoo(Foo foo);

  /** delete a foo */
  void deleteFoo(String fooId);

  /** create a foo query */
  FooQuery createFooQuery();

}
