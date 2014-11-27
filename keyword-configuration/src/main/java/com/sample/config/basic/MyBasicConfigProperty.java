package com.sample.config.basic;

import static de.agito.cps.core.engine.keyword.KeywordConfigPropertyType.EXTENSION;
import de.agito.cps.core.config.parser.BooleanPropertyParser;
import de.agito.cps.core.config.parser.IntegerPropertyParser;
import de.agito.cps.core.config.parser.Property;
import de.agito.cps.core.config.parser.StringArrayPropertyParser;
import de.agito.cps.core.config.parser.StringListPropertyParser;
import de.agito.cps.core.config.parser.StringMapArrayPropertyParser;
import de.agito.cps.core.config.parser.StringMapPropertyParser;
import de.agito.cps.core.engine.keyword.KeywordConfigProperty;
import de.agito.cps.core.engine.keyword.KeywordConfigPropertyType;

public enum MyBasicConfigProperty implements KeywordConfigProperty {

  exampleAttributeString("exampleAttributeString", EXTENSION),

  @Property(parser = IntegerPropertyParser.class)
  exampleAttributeInteger("exampleAttributeInteger", EXTENSION),

  @Property(parser = BooleanPropertyParser.class)
  exampleAttributeBoolean("exampleAttributeBoolean", EXTENSION),

  @Property(parser = StringListPropertyParser.class)
  exampleAttributeStringList("exampleAttributeStringList", EXTENSION),

  @Property(parser = StringArrayPropertyParser.class)
  exampleAttributeStringArray("exampleAttributeStringArray", EXTENSION),

  @Property(parser = StringMapArrayPropertyParser.class)
  exampleAttributeStringMapArray("exampleAttributeStringMapArray", EXTENSION),

  @Property(parser = StringMapPropertyParser.class)
  exampleAttributeStringMap("exampleAttributeStringMap", EXTENSION),

  @Property(defaultValue = "aDefaultValue")
  exampleAttributeDefault("exampleAttributeDefault", EXTENSION);

  public final static String KEYWORD_ID = "com.sample.MyBasicConfiguration";

  private final String key;
  private final KeywordConfigPropertyType type;

  private MyBasicConfigProperty(String key, KeywordConfigPropertyType type) {
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
