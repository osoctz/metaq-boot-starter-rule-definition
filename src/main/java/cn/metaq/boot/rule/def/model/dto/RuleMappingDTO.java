package cn.metaq.boot.rule.def.model.dto;

import cn.metaq.boot.rule.def.jackson.databind.ModelDefDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;

public class RuleMappingDTO implements Serializable {

  private String targetId;

  private Integer targetType;
  
  @JsonDeserialize(using = ModelDefDeserializer.class)
  private ModelDefinition rule;
}
