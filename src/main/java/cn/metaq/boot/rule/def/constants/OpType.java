package cn.metaq.boot.rule.def.constants;

public enum OpType {
  AND, OR, TERN, METH, VAR;

  public static OpType of(String value) {

    OpType[] values = OpType.values();
    for (OpType v : values) {
      if (v.toString().equals(value)) {
        return v;
      }
    }

    return null;
  }
}
