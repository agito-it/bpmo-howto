package com.sample.engine.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.sample.engine.MyEngine;
import com.sample.engine.foo.Foo;

import de.agito.cps.core.context.ClientContextFactory;
import de.agito.cps.process.camunda.test.BPMOApplicationConfiguration;
import de.agito.cps.test.camunda.BPMOProcessEngineRule;

@BPMOApplicationConfiguration(applicationId = "HowtoEngineApplication")
public class FooServiceTest {

  @Rule
  public BPMOProcessEngineRule bpmoRule = new BPMOProcessEngineRule();

  public MyEngine myEngine = null;

  @Before
  public void setup() {
    myEngine = ClientContextFactory.getApplicationEngine();
  }

  @After
  public void tearDown() {
    for (final Foo foo : myEngine.getFooService().createFooQuery().list())
      myEngine.getFooService().deleteFoo(foo.getId());
  }

  @Test
  public void testCreateFoo() {
    // create
    Foo aFoo = myEngine.getFooService().createFoo("test");
    myEngine.getFooService().saveFoo(aFoo);

    // assert
    assertNotNull(aFoo.getId());
  }

  @Test
  public void testUpdateFoo() {
    // create
    Foo aFoo = myEngine.getFooService().createFoo("test");
    myEngine.getFooService().saveFoo(aFoo);

    // update
    aFoo.setName("newName");
    aFoo.setValue("newValue");
    myEngine.getFooService().saveFoo(aFoo);

    // assert
    final Foo assertFoo = myEngine.getFooService().createFooQuery().id(aFoo.getId()).singleResult();
    assertEquals("newName", assertFoo.getName());
    assertEquals("newValue", assertFoo.getValue());
  }

  @Test
  public void testDeleteFoo() {
    // create
    Foo aFoo = myEngine.getFooService().createFoo("test");
    myEngine.getFooService().saveFoo(aFoo);

    // delete
    myEngine.getFooService().deleteFoo(aFoo.getId());

    // assert
    assertNull(myEngine.getFooService().createFooQuery().id(aFoo.getId()).singleResult());
  }

}