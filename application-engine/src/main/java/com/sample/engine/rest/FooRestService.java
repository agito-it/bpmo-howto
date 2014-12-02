package com.sample.engine.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import de.agito.cps.commons.rest.dto.CountResultDto;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface FooRestService {

  public final static String PATH = "/foo";

  @GET
  @Path(PATH)
  @Produces(MediaType.APPLICATION_JSON)
  List<FooDto> queryFoos(@Context UriInfo uriInfo, @QueryParam("firstResult") Integer firstResult,
      @QueryParam("maxResults") Integer maxResults);

  @POST
  @Path(PATH)
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  List<FooDto> queryFoos(FooQueryDto query, @QueryParam("firstResult") Integer firstResult,
      @QueryParam("maxResults") Integer maxResults);

  @GET
  @Path(PATH + "/count")
  @Produces(MediaType.APPLICATION_JSON)
  CountResultDto queryFooCount(@Context UriInfo uriInfo);

  @POST
  @Path(PATH + "/count")
  @Produces(MediaType.APPLICATION_JSON)
  CountResultDto queryFooCount(FooQueryDto queryDto);

  @POST
  @Path(PATH + "/create")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  FooDto createFoo(FooDto dto);

  @Path(PATH + "/{id}")
  FooResource getFoo(@PathParam("id") String id);

}
