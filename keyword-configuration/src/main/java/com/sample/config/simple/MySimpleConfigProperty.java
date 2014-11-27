package com.sample.config.simple;

import static de.agito.cps.core.engine.keyword.KeywordConfigPropertyType.EXTENSION;
import de.agito.cps.core.config.parser.BooleanPropertyParser;
import de.agito.cps.core.config.parser.Property;
import de.agito.cps.core.engine.keyword.KeywordConfigProperty;
import de.agito.cps.core.engine.keyword.KeywordConfigPropertyType;

public enum MySimpleConfigProperty implements KeywordConfigProperty {

  fooAttribute("fooAttribute", EXTENSION),

  @Property(parser = BooleanPropertyParser.class)
  barAttribute("barAttribute", EXTENSION),

  @Property(defaultValue = "aDefaultValue")
  optionalAttribute("optionalAttribute", EXTENSION);

  public final static String KEYWORD_ID = "com.sample.MySimpleConfiguration";

  private final String key;
  private final KeywordConfigPropertyType type;

  private MySimpleConfigProperty(String key, KeywordConfigPropertyType type) {
    this.key = key;
    this.type = type;
  }

  @Override
  public String getKey() {
    return key;
  }

  @Override
  public KeywordConfigPropertyType getType() {
    return type;
  }

}
