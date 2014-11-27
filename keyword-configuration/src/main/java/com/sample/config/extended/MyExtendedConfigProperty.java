package com.sample.config.extended;

import static de.agito.cps.core.engine.keyword.KeywordConfigPropertyType.ENTRY_EXTENSION;
import de.agito.cps.core.config.parser.BooleanPropertyParser;
import de.agito.cps.core.config.parser.IntegerPropertyParser;
import de.agito.cps.core.config.parser.Property;
import de.agito.cps.core.config.parser.StringArrayPropertyParser;
import de.agito.cps.core.config.parser.StringListPropertyParser;
import de.agito.cps.core.config.parser.StringMapArrayPropertyParser;
import de.agito.cps.core.config.parser.StringMapPropertyParser;
import de.agito.cps.core.engine.keyword.KeywordConfigProperty;
import de.agito.cps.core.engine.keyword.KeywordConfigPropertyType;

public enum MyExtendedConfigProperty implements KeywordConfigProperty {

  id(null, KeywordConfigPropertyType.ENTRY_KEY),

  name(null, KeywordConfigPropertyType.ENTRY_VALUE),

  exampleAttributeString("exampleAttributeString", ENTRY_EXTENSION),

  @Property(parser = IntegerPropertyParser.class)
  exampleAttributeInteger("exampleAttributeInteger", ENTRY_EXTENSION),

  @Property(parser = BooleanPropertyParser.class)
  exampleAttributeBoolean("exampleAttributeBoolean", ENTRY_EXTENSION),

  @Property(parser = StringListPropertyParser.class)
  exampleAttributeStringList("exampleAttributeStringList", ENTRY_EXTENSION),

  @Property(parser = StringArrayPropertyParser.class)
  exampleAttributeStringArray("exampleAttributeStringArray", ENTRY_EXTENSION),

  @Property(parser = StringMapArrayPropertyParser.class)
  exampleAttributeStringMapArray("exampleAttributeStringMapArray", ENTRY_EXTENSION),

  @Property(parser = StringMapPropertyParser.class)
  exampleAttributeStringMap("exampleAttributeStringMap", ENTRY_EXTENSION),

  @Property(defaultValue = "aDefaultValue")
  exampleAttributeDefault("exampleAttributeDefault", ENTRY_EXTENSION);

  public final static String KEYWORD_ID = "com.sample.MyExtendedConfiguration";

  private final String key;
  private final KeywordConfigPropertyType type;

  private MyExtendedConfigProperty(String key, KeywordConfigPropertyType type) {
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
