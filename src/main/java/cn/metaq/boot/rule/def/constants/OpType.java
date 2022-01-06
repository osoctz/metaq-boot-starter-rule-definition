package cn.metaq.boot.rule.def.constants;

import org.apache.commons.lang3.StringUtils;

public enum OpType {
  AND, OR, TERN, METH, VAR,MAP;

  public static OpType of(String value) {

    if(StringUtils.isBlank(value)){
      return VAR;
    }

    OpType[] values = OpType.values();
    for (OpType v : values) {
      if (v.toString().equals(value)) {
        return v;
      }
    }

    return null;
  }
}
