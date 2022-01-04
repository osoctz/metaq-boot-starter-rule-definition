package cn.metaq.boot.rule.def.model.dto;

import cn.metaq.boot.rule.def.constants.OpType;
import com.github.paulosalonso.spel.builder.common.EndpointParameter;
import com.github.paulosalonso.spel.builder.common.Expression;

public class ParameterDefinition implements ModelDefinition{

  protected OpType type = OpType.VAR;
  private String name;
  private Integer index;

  public OpType getType() {
    return type;
  }

  public void setType(OpType type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  @Override
  public Expression build() {
    return EndpointParameter.endpointParameter(name);
  }
}
