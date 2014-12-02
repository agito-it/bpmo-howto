package com.sample.engine.rest.client;

import de.agito.cps.commons.rest.client.spi.RestClientFactory;
import de.agito.cps.commons.rest.connector.spi.RestConnector;
import de.agito.cps.core.context.ClientContextFactory;

public class MyEngineRestClientFactory implements RestClientFactory<MyEngineRestClient> {

  @Override
  public MyEngineRestClient create(RestConnector connector) {
    return new MyEngineRestClient(connector);
  }

  @Override
  public String getDefaultEnpointURI() {
    return "/bpmo-howto-application-engine/rest/" + ClientContextFactory.getVariant();
  }

}
