package com.sample.engine.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

public interface FooResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public FooDto getFoo(@Context UriInfo context);

  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public void deleteFoo();

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public void updateFoo(FooDto foo);

}
