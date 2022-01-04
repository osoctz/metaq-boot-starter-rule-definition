package cn.metaq.boot.rule.def.model.dto;

import static cn.metaq.boot.rule.def.constants.OpType.METH;

import cn.metaq.boot.rule.def.constants.OpType;
import com.github.paulosalonso.spel.builder.common.Expression;

public interface ModelDefinition {

  OpType type = METH;

  Expression build();
}
