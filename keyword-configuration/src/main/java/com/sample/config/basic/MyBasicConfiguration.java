package com.sample.config.basic;

import java.util.List;
import java.util.Map;

public class MyBasicConfiguration {

  private String exampleAttributeString;

  private Integer exampleAttributeInteger;

  private Boolean exampleAttributeBoolean;

  private List<String> exampleAttributeStringList;

  private String[] exampleAttributeStringArray;

  private Map<String, String> exampleAttributeStringMap;

  private Map<String, String[]> exampleAttributeStringMapArray;

  public String getExampleAttributeString() {
    return exampleAttributeString;
  }

  public Integer getExampleAttributeInteger() {
    return exampleAttributeInteger;
  }

  public Boolean getExampleAttributeBoolean() {
    return exampleAttributeBoolean;
  }

  public List<String> getExampleAttributeStringList() {
    return exampleAttributeStringList;
  }

  public String[] getExampleAttributeStringArray() {
    return exampleAttributeStringArray;
  }

  public Map<String, String> getExampleAttributeStringMap() {
    return exampleAttributeStringMap;
  }

  public Map<String, String[]> getExampleAttributeStringMapArray() {
    return exampleAttributeStringMapArray;
  }

}
