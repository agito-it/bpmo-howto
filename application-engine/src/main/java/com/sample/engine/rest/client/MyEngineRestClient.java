package com.sample.engine.rest.client;

import com.sample.engine.rest.FooRestService;

import de.agito.cps.commons.rest.client.spi.AbstractRestClient;
import de.agito.cps.commons.rest.connector.spi.RestConnector;

public class MyEngineRestClient extends AbstractRestClient {

  public MyEngineRestClient(RestConnector connector) {
    super(connector);
  }

  public FooRestService getFooRestService() {
    return org.jboss.resteasy.client.ProxyFactory.create(FooRestService.class, connector.getEndpointURI().toString(),
        connector.getHint(org.jboss.resteasy.client.ClientExecutor.class));
  }
}
