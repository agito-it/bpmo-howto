package com.sample.engine.rest;

import javax.ws.rs.core.MultivaluedMap;

import com.sample.engine.MyEngine;
import com.sample.engine.foo.FooQuery;

import de.agito.cps.commons.rest.dto.AbstractQueryDto;
import de.agito.cps.commons.rest.dto.QueryParam;

public class FooQueryDto extends AbstractQueryDto<MyEngine, FooQuery> {

  private String id;
  private String name;
  private String value;

  public FooQueryDto() {
    super();
  }

  public FooQueryDto(MultivaluedMap<String, String> queryParameters) {
    super(queryParameters);
  }

  @Override
  protected boolean isValidSortByValue(String value) {
    return true;
  }

  @Override
  protected FooQuery createNewQuery(MyEngine engine) {
    return engine.getFooService().createFooQuery();
  }

  @Override
  protected void applyFilters(FooQuery query) {
    if (id != null)
      query.id(id);
    if (name != null)
      query.name(name);
    if (value != null)
      query.value(value);
  }

  @Override
  protected void applySortingOptions(FooQuery query) {

  }

  @QueryParam("id")
  public void setId(String id) {
    this.id = id;
  }

  @QueryParam("name")
  public void setName(String name) {
    this.name = name;
  }

  @QueryParam("value")
  public void setValue(String value) {
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }

}
