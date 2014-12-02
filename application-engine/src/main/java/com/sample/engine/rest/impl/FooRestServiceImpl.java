package com.sample.engine.rest.impl;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.sample.engine.MyEngine;
import com.sample.engine.foo.Foo;
import com.sample.engine.foo.FooQuery;
import com.sample.engine.rest.FooDto;
import com.sample.engine.rest.FooQueryDto;
import com.sample.engine.rest.FooResource;
import com.sample.engine.rest.FooRestService;

import de.agito.cps.commons.rest.dto.CountResultDto;
import de.agito.cps.commons.rest.impl.AbstractRestService;

public class FooRestServiceImpl extends AbstractRestService<MyEngine> implements FooRestService {

  @Override
  public FooDto createFoo(FooDto dto) {
    Foo newFoo = engine.getFooService().createFoo(dto.getName());
    FooDto.update(dto, newFoo);

    newFoo = engine.getFooService().saveFoo(newFoo);

    dto.setId(newFoo.getId());

    return dto;
  }

  @Override
  public FooResource getFoo(String id) {
    return new FooResourceImpl(getEngine(), id);
  }

  @Override
  public List<FooDto> queryFoos(UriInfo uriInfo, Integer firstResult, Integer maxResults) {
    final FooQueryDto queryDto = new FooQueryDto(uriInfo.getQueryParameters());
    return queryFoos(queryDto, firstResult, maxResults);
  }

  @Override
  public List<FooDto> queryFoos(FooQueryDto query, Integer firstResult, Integer maxResults) {
    final List<Foo> matchingResult = executePaginatedQuery(query.toQuery(getEngine()), firstResult, maxResults);
    return FooDto.fromFooList(matchingResult);
  }

  @Override
  public CountResultDto queryFooCount(UriInfo uriInfo) {
    final FooQueryDto queryDto = new FooQueryDto(uriInfo.getQueryParameters());
    return queryFooCount(queryDto);
  }

  @Override
  public CountResultDto queryFooCount(FooQueryDto queryDto) {
    final FooQuery query = queryDto.toQuery(getEngine());

    long count = query.count();
    CountResultDto result = new CountResultDto();
    result.setCount(count);

    return result;
  }

  protected List<Foo> executePaginatedQuery(final FooQuery query, Integer firstResult, Integer maxResults) {
    if (firstResult == null) {
      firstResult = 0;
    }
    if (maxResults == null) {
      maxResults = Integer.MAX_VALUE;
    }
    return query.listPage(firstResult, maxResults);
  }
}
