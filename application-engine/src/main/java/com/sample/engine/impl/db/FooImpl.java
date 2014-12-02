package com.sample.engine.impl.db;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.sample.engine.foo.Foo;

import de.agito.cps.commons.base.engine.db.HasRevision;
import de.agito.cps.commons.base.engine.db.IdGenerator;
import de.agito.cps.commons.base.engine.db.PersistentObject;

public class FooImpl implements Foo, HasRevision, Serializable, PersistentObject {

  private static final long serialVersionUID = -3121087358804062752L;

  protected String id;
  protected String name;
  protected String value;
  protected int revision;

  public FooImpl() {
  }

  public FooImpl(String name) {
    setName(name);
  }

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    if (name == null)
      throw new IllegalArgumentException("Name must not be null.");
    this.name = name;
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String getPK() {
    return id;
  }

  @Override
  public void setPK(IdGenerator idGenerator) {
    this.id = idGenerator.getNextId();
  }

  @Override
  public void setRevision(int revision) {
    this.revision = revision;
  }

  @Override
  public int getRevision() {
    return revision;
  }

  @Override
  public int getRevisionNext() {
    return revision + 1;
  }

  @Override
  public Object getPersistentState() {
    Map<String, Object> persistentState = new HashMap<String, Object>();
    persistentState.put("name", name);
    persistentState.put("value", value);
    return persistentState;
  }
}
