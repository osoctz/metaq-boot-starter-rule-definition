package cn.metaq.boot.rule.def.model.dto;

import static com.github.paulosalonso.spel.builder.ContextVariable.contextVariable;

import cn.metaq.boot.rule.def.constants.OpType;
import com.github.paulosalonso.spel.builder.common.Expression;
import com.github.paulosalonso.spel.builder.common.Parameter;
import java.util.List;
import org.springframework.util.CollectionUtils;

public class MethodDefinition implements ModelDefinition {

  protected OpType type = OpType.METH;
  private String ref;
  private String name;

  private List<ParameterDefinition> parameters;

  @Override
  public Expression build() {
    Parameter[] params;
    if (CollectionUtils.isEmpty(parameters)) {
      params = new Parameter[]{};
    } else {
      params = parameters.stream().map(s -> s.build()).toArray(Parameter[]::new);
    }
    return contextVariable(ref).method(name, params);
  }

  public OpType getType() {
    return type;
  }

  public void setType(OpType type) {
    this.type = type;
  }

  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ParameterDefinition> getParameters() {
    return parameters;
  }

  public void setParameters(List<ParameterDefinition> parameters) {
    this.parameters = parameters;
  }
}
