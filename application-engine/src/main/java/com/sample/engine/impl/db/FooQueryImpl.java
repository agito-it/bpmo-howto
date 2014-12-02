package com.sample.engine.impl.db;

import java.util.List;

import com.sample.engine.foo.Foo;
import com.sample.engine.foo.FooQuery;
import com.sample.engine.impl.AbstractQuery;
import com.sample.engine.impl.CommandContext;

import de.agito.cps.commons.base.engine.execution.CommandExecutor;
import de.agito.cps.commons.base.engine.query.Page;

public class FooQueryImpl extends AbstractQuery<FooQuery, Foo> implements FooQuery {

  private static final long serialVersionUID = -3891673713686267287L;

  protected String id;
  protected String name;
  protected String value;

  // constructors ////////////////////////

  public FooQueryImpl() {
    super();
  }

  public FooQueryImpl(CommandContext commandContext) {
    super(commandContext);
  }

  public FooQueryImpl(CommandExecutor<CommandContext> commandExecutor) {
    super(commandExecutor);
  }

  // foo query ////////////////////////

  @Override
  public FooQuery id(String id) {
    this.id = id;
    return this;
  }

  @Override
  public FooQuery name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FooQuery value(String value) {
    this.value = value;
    return this;
  }

  // abstract query ////////////////////////

  @Override
  public long executeCount(CommandContext commandContext) {
    checkQueryOk();
    return commandContext.getFooManager().findFooCountByQueryCriteria(this);
  }

  @Override
  public List<Foo> executeList(CommandContext commandContext, Page page) {
    checkQueryOk();
    return commandContext.getFooManager().findFoosByQueryCriteria(this, page);
  }

  @Override
  public String getOrderByDefault() {
    return "NAME_ asc";
  }

  // getters ////////////////////////

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
