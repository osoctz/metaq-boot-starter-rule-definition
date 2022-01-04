package cn.metaq.boot.rule.def.jackson.databind;

import cn.metaq.boot.rule.def.constants.OpType;
import cn.metaq.boot.rule.def.model.dto.LogicalDefinition;
import cn.metaq.boot.rule.def.model.dto.MethodDefinition;
import cn.metaq.boot.rule.def.model.dto.ModelDefinition;
import cn.metaq.boot.rule.def.model.dto.TernaryDefinition;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ModelDefDeserializer extends JsonDeserializer<ModelDefinition> {

  @Override
  public ModelDefinition deserialize(JsonParser p, DeserializationContext deserializationContext)
      throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    // 表达式json
    JsonNode node = p.getCodec().readTree(p);

    String json = node.toString();
    String type =node.path("type").textValue();
    ModelDefinition def;

    switch (OpType.of(type)){
      case AND:
      case OR:
        def = mapper.readValue(json, LogicalDefinition.class);
        break;
      case TERN:
        def = mapper.readValue(json, TernaryDefinition.class);
        break;
      default:
        def = mapper.readValue(json, MethodDefinition.class);
    }
    return def;
  }
}
