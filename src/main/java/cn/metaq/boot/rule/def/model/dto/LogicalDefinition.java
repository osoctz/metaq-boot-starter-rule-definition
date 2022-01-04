package cn.metaq.boot.rule.def.model.dto;

import cn.metaq.boot.rule.def.constants.OpType;
import cn.metaq.boot.rule.def.jackson.databind.ModelDefListDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.paulosalonso.spel.builder.common.Expression;
import java.util.List;
import org.springframework.util.CollectionUtils;

public class LogicalDefinition implements ModelDefinition {

  protected OpType type = OpType.AND;

  private Boolean group = Boolean.FALSE;

  @JsonDeserialize(using = ModelDefListDeserializer.class)
  private List<ModelDefinition> list;

  @Override
  public Expression build() {
    Expression expression = null;
    switch (type) {
      case AND:
        if (!CollectionUtils.isEmpty(list)) {
          expression = list.get(0).build();

          for (int i = 1; i < list.size(); i++) {
            expression =expression.and(list.get(i).build());
          }
        }
        break;
      case OR:
        if (!CollectionUtils.isEmpty(list)) {
          expression = list.get(0).build();

          for (int i = 1; i < list.size(); i++) {
            expression =expression.or(list.get(i).build());
          }

        }
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + type);
    }

    if(group){
      expression=expression.group();
    }
    return expression;
  }

  public OpType getType() {
    return type;
  }

  public void setType(OpType type) {
    this.type = type;
  }

  public Boolean getGroup() {
    return group;
  }

  public void setGroup(Boolean group) {
    this.group = group;
  }

  public List<ModelDefinition> getList() {
    return list;
  }

  public void setList(List<ModelDefinition> list) {
    this.list = list;
  }
}
