package com.sample.engine.rest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.sample.engine.FooService;
import com.sample.engine.MyEngine;
import com.sample.engine.foo.Foo;
import com.sample.engine.foo.FooQuery;
import com.sample.engine.impl.db.FooImpl;
import com.sample.engine.rest.FooDto;
import com.sample.engine.rest.FooRestService;
import com.sample.engine.rest.client.MyEngineRestClient;
import com.sample.engine.rest.test.util.ResteasyServerBootstrap;

import de.agito.cps.commons.rest.connector.spi.resteasy.RestEasyConnectorFactory;
import de.agito.cps.commons.rest.impl.AbstractRestService;
import de.agito.cps.commons.rest.test.util.EmbeddedServerBootstrap;

public class FooRestServiceTest extends AbstractRestService<MyEngine> {

  protected static EmbeddedServerBootstrap serverBootstrap;

  protected static MyEngineRestClient client;
  protected FooService fooServiceMock;

  @BeforeClass
  public static void setUpEmbeddedRuntime() {
    serverBootstrap = new ResteasyServerBootstrap();
    serverBootstrap.start();
    client = new RestEasyConnectorFactory().create(MyEngineRestClient.class, serverBootstrap.getRestEndpoint())
        .createClient();
  }

  @AfterClass
  public static void tearDownEmbeddedRuntime() {
    serverBootstrap.stop();
  }

  @Before
  public void setUpRuntimeData() {
    fooServiceMock = mock(FooService.class);
    when(engine.getFooService()).thenReturn(fooServiceMock);
  }

  @Test
  public void testCreateFoo() throws Exception {

    when(fooServiceMock.createFoo(any(String.class))).then(new Answer<Foo>() {
      @Override
      public Foo answer(InvocationOnMock invocation) throws Throwable {
        return (Foo) new FooImpl((String) invocation.getArguments()[0]);
      }
    });

    when(fooServiceMock.saveFoo(any(Foo.class))).then(new Answer<Foo>() {
      @Override
      public Foo answer(InvocationOnMock invocation) throws Throwable {
        return (Foo) invocation.getArguments()[0];
      }
    });

    FooRestService fooRestService = client.getFooRestService();

    FooDto dto = new FooDto();
    dto.setName("TestName");
    dto.setValue("TestValue");
    FooDto rFoo = fooRestService.createFoo(dto);

    assertNotNull(rFoo);

  }

  @Test
  public void testFooQuery() throws Exception {
    final Foo assertFoo = new FooImpl("test");
    assertFoo.setName("testName");
    assertFoo.setValue("testValue");

    final FooQuery query = mock(FooQuery.class);
    when(query.id(any(String.class))).thenReturn(query);
    when(query.singleResult()).thenReturn(assertFoo);

    when(fooServiceMock.createFooQuery()).then(new Answer<FooQuery>() {
      @Override
      public FooQuery answer(InvocationOnMock invocation) throws Throwable {
        return query;
      }
    });

    FooRestService fooRestService = client.getFooRestService();

    FooDto dtoR = fooRestService.getFoo("foo").getFoo(null);

    assertNotNull(dtoR);
    assertEquals("testName", dtoR.getName());
    assertEquals("testValue", dtoR.getValue());
  }
}
