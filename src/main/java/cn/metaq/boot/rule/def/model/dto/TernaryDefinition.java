package cn.metaq.boot.rule.def.model.dto;

import cn.metaq.boot.rule.def.constants.OpType;
import cn.metaq.boot.rule.def.jackson.databind.ModelDefDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.paulosalonso.spel.builder.common.Expression;

public class TernaryDefinition implements ModelDefinition {

  protected OpType type = OpType.TERN;

  @JsonDeserialize(using = ModelDefDeserializer.class)
  private ModelDefinition on;

  @JsonDeserialize(using = ModelDefDeserializer.class)
  private ModelDefinition left;

  @JsonDeserialize(using = ModelDefDeserializer.class)
  private ModelDefinition right;

  @Override
  public Expression build() {
    return on.build().tern(left.build(), right.build());
  }

  public OpType getType() {
    return type;
  }

  public void setType(OpType type) {
    this.type = type;
  }

  public ModelDefinition getOn() {
    return on;
  }

  public void setOn(ModelDefinition on) {
    this.on = on;
  }

  public ModelDefinition getLeft() {
    return left;
  }

  public void setLeft(ModelDefinition left) {
    this.left = left;
  }

  public ModelDefinition getRight() {
    return right;
  }

  public void setRight(ModelDefinition right) {
    this.right = right;
  }
}
