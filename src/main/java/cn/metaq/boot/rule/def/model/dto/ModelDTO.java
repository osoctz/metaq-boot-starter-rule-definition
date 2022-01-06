package cn.metaq.boot.rule.def.model.dto;

import cn.metaq.boot.rule.def.jackson.databind.ModelDefDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ModelDTO {

  private String targetId;

  private Integer targetType;

  private Integer bizType;

  @JsonDeserialize(using = ModelDefDeserializer.class)
  private ModelDefinition rule;

  public String getTargetId() {
    return targetId;
  }

  public void setTargetId(String targetId) {
    this.targetId = targetId;
  }

  public Integer getTargetType() {
    return targetType;
  }

  public void setTargetType(Integer targetType) {
    this.targetType = targetType;
  }

  public Integer getBizType() {
    return bizType;
  }

  public void setBizType(Integer bizType) {
    this.bizType = bizType;
  }

  public ModelDefinition getRule() {
    return rule;
  }

  public void setRule(ModelDefinition rule) {
    this.rule = rule;
  }
}
