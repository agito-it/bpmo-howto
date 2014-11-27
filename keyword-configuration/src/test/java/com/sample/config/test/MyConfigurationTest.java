package com.sample.config.test;

import static de.agito.cps.core.utils.Constants.DEFAULT_CLIENT;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import com.sample.config.basic.MyBasicConfigProperty;
import com.sample.config.basic.MyBasicConfiguration;
import com.sample.config.extended.MyExtendedConfigProperty;
import com.sample.config.extended.MyExtendedConfiguration;
import com.sample.config.simple.MySimpleConfigProperty;

import de.agito.cps.core.engine.keyword.Keyword;
import de.agito.cps.core.engine.keyword.KeywordEntry;
import de.agito.cps.process.camunda.test.BPMOApplicationConfiguration;
import de.agito.cps.test.camunda.BPMOProcessEngineRule;

@BPMOApplicationConfiguration
public class MyConfigurationTest {

  @Rule
  public BPMOProcessEngineRule bpmoRule = new BPMOProcessEngineRule();

  @Test
  public void testMySimpleConfiguration() {
    // get the keyword
    final Keyword keyword = bpmoRule.getBpmoEngine().getKeywordService().createKeywordQuery()
        .id(MySimpleConfigProperty.KEYWORD_ID).client(DEFAULT_CLIENT).includeEntries().singleResult();

    // get the config values

    final String fooAttribute = keyword.getConfigValue(MySimpleConfigProperty.fooAttribute);

    final Boolean barAttribute = keyword.getConfigValue(MySimpleConfigProperty.barAttribute);

    final String optionalAttribute = keyword.getConfigValue(MySimpleConfigProperty.optionalAttribute);

    assertEquals("foo", fooAttribute);
    assertEquals(true, barAttribute);
    assertEquals("aDefaultValue", optionalAttribute);
  }

  @Test
  public void testMyExtendedConfigurationInjection() {

    // get the keyword
    final Keyword keyword = bpmoRule.getBpmoEngine().getKeywordService().createKeywordQuery()
        .id(MyExtendedConfigProperty.KEYWORD_ID).client(DEFAULT_CLIENT).includeEntries().singleResult();

    final List<MyExtendedConfiguration> configurations = new ArrayList<MyExtendedConfiguration>();

    // fill configurations per entry
    for (KeywordEntry entry : keyword.getEntries().values()) {

      // create new empty configuration
      final MyExtendedConfiguration configuration = new MyExtendedConfiguration();

      // inject with configuration values
      entry.injectConfiguration(MyExtendedConfigProperty.values(), configuration);

      configurations.add(configuration);

    }

  }

  @Test
  public void testMyBasicConfigurationInjection() {

    // get the keyword
    final Keyword keyword = bpmoRule.getBpmoEngine().getKeywordService().createKeywordQuery()
        .id(MyBasicConfigProperty.KEYWORD_ID).client(DEFAULT_CLIENT).includeEntries().singleResult();

    // create new empty configuration
    final MyBasicConfiguration configuration = new MyBasicConfiguration();

    // inject with configuration values
    keyword.injectConfiguration(MyBasicConfigProperty.values(), configuration);

  }

  @SuppressWarnings("unused")
  @Test
  public void testMyBasicConfigurationGetConfigValue() {

    // get the keyword
    final Keyword keyword = bpmoRule.getBpmoEngine().getKeywordService().createKeywordQuery()
        .id(MyBasicConfigProperty.KEYWORD_ID).client(DEFAULT_CLIENT).includeEntries().singleResult();

    // get values by GetConfigValue

    String exampleAttributeDefault = keyword.getConfigValue(MyBasicConfigProperty.exampleAttributeDefault);

    String exampleAttributeString = keyword.getConfigValue(MyBasicConfigProperty.exampleAttributeString);

    Integer exampleAttributeInteger = keyword.getConfigValue(MyBasicConfigProperty.exampleAttributeInteger);

    Boolean exampleAttributeBoolean = keyword.getConfigValue(MyBasicConfigProperty.exampleAttributeBoolean);

    List<String> exampleAttributeStringList = keyword.getConfigValue(MyBasicConfigProperty.exampleAttributeStringList);

    String[] exampleAttributeStringArray = keyword.getConfigValue(MyBasicConfigProperty.exampleAttributeStringArray);

    Map<String, String> exampleAttributeStringMap = keyword
        .getConfigValue(MyBasicConfigProperty.exampleAttributeStringMap);

    Map<String, String[]> exampleAttributeStringMapArray = keyword
        .getConfigValue(MyBasicConfigProperty.exampleAttributeStringMapArray);
  }

}