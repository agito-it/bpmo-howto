package com.sample.engine.rest.test.util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sample.engine.FooService;
import com.sample.engine.MyEngine;

import de.agito.cps.commons.base.engine.BaseEngine;
import de.agito.cps.commons.rest.spi.EngineProvider;
import de.agito.cps.core.engine.BPMOEngine;

public class MyEngineMockProvider implements EngineProvider {

  private static MyEngine cachedEngine;

  public void resetEngines() {
    cachedEngine = null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends BaseEngine> T getApplicationEngine() {
    if (cachedEngine == null) {
      cachedEngine = mockPublishingEngine();
    }
    return (T) cachedEngine;
  }

  @Override
  public BPMOEngine getBPMOEngine() {
    throw new UnsupportedOperationException();
  }

  private MyEngine mockPublishingEngine() {
    MyEngine engine = mock(MyEngine.class);
    mockServices(engine);
    return engine;
  }

  private void mockServices(MyEngine engine) {
    FooService fooService = mock(FooService.class);
    when(engine.getFooService()).thenReturn(fooService);
  }

}
