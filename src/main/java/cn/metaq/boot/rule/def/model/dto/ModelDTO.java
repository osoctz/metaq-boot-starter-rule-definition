package cn.metaq.boot.rule.def.model.dto;

import cn.metaq.boot.rule.def.jackson.databind.ModelDefDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ModelDTO {

  @JsonDeserialize(using = ModelDefDeserializer.class)
  private ModelDefinition rule;

  public ModelDefinition getRule() {
    return rule;
  }

  public void setRule(ModelDefinition rule) {
    this.rule = rule;
  }
}
