package com.sample.engine;

import com.sample.engine.foo.Foo;

import de.agito.cps.commons.base.engine.BaseEngine;

/**
 * My engine.
 * 
 * @author agito
 *
 */
public interface MyEngine extends BaseEngine {

  /**
   * Retrieve the Sample Service for managing {@link Foo foos}.
   */
  public FooService getFooService();

}
