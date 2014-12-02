package com.sample.engine.rest;

import java.util.ArrayList;
import java.util.List;

import com.sample.engine.foo.Foo;

public class FooDto {

  protected String id;
  protected String name;
  protected String value;

  public static void update(FooDto dto, Foo foo) {
    foo.setName(dto.getName());
    foo.setValue(dto.getValue());
  }

  public static List<FooDto> fromFooList(List<Foo> resultList) {
    final List<FooDto> result = new ArrayList<FooDto>();
    for (Foo team : resultList) {
      result.add(fromFoo(team));
    }
    return result;
  }

  public static FooDto fromFoo(Foo foo) {
    FooDto dto = new FooDto();
    dto.setId(foo.getId());
    dto.setName(foo.getName());
    dto.setValue(foo.getValue());
    return dto;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
