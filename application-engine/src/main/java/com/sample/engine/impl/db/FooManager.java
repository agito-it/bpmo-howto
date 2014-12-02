package com.sample.engine.impl.db;

import java.util.List;

import com.sample.engine.foo.Foo;
import com.sample.engine.impl.CommandContext;

import de.agito.cps.commons.base.engine.db.AbstractBaseEntityManager;
import de.agito.cps.commons.base.engine.query.Page;

public class FooManager extends AbstractBaseEntityManager<CommandContext> {

  public long findFooCountByQueryCriteria(FooQueryImpl query) {
    return (Long) getDbSqlSession().selectOne("selectFooCountByQueryCriteria", query);
  }

  public List<Foo> findFoosByQueryCriteria(FooQueryImpl query, Page page) {
    return getDbSqlSession().selectList("selectFoosByQueryCriteria", query, page);
  }

}
