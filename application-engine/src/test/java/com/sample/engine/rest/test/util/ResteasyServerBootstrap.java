package com.sample.engine.rest.test.util;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;

import com.sample.engine.rest.impl.DefaultApplication;

import de.agito.cps.commons.rest.test.util.EmbeddedServerBootstrap;

public class ResteasyServerBootstrap extends EmbeddedServerBootstrap {

  private NettyJaxrsServer server;

  public ResteasyServerBootstrap() {
    setupServer(new DefaultApplication());
  }

  public ResteasyServerBootstrap(Application application) {
    setupServer(application);
  }

  @Override
  public void start() {
    server.start();
  }

  @Override
  public void stop() {
    server.stop();
  }

  private void setupServer(Application application) {
    server = new NettyJaxrsServer();
    server.setRootResourcePath(ROOT_RESOURCE_PATH);
    server.setPort(getPort());
    server.getDeployment().setApplication(application);
  }

}
