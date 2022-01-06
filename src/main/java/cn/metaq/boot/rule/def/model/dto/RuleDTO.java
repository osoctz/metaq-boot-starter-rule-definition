package cn.metaq.boot.rule.def.model.dto;

import cn.metaq.boot.rule.def.constants.OpType;
import cn.metaq.boot.rule.def.jackson.databind.ModelDefListDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.List;

public class RuleDTO implements Serializable {

  protected OpType type = OpType.METH;
  private String name;

  @JsonDeserialize(using = ModelDefListDeserializer.class)
  private List<ParameterDefinition> parameters;
}
