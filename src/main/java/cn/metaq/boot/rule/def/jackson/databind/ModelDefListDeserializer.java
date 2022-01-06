package cn.metaq.boot.rule.def.jackson.databind;

import cn.metaq.boot.rule.def.constants.OpType;
import cn.metaq.boot.rule.def.model.dto.LogicalDefinition;
import cn.metaq.boot.rule.def.model.dto.MapParameterDefinition;
import cn.metaq.boot.rule.def.model.dto.MethodDefinition;
import cn.metaq.boot.rule.def.model.dto.ModelDefinition;
import cn.metaq.boot.rule.def.model.dto.ParameterDefinition;
import cn.metaq.boot.rule.def.model.dto.TernaryDefinition;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class ModelDefListDeserializer extends JsonDeserializer<List<ModelDefinition>> {

  @Override
  public List<ModelDefinition> deserialize(JsonParser p, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();
    // 表达式json
    JsonNode node = p.getCodec().readTree(p);
    List<ModelDefinition> defs=new ArrayList<>();
    if(node.isArray()){
      Iterator<JsonNode> it=node.iterator();
      while (it.hasNext()){
        JsonNode s= it.next();
        String json = s.toString();
        String type =s.path("type").textValue();

        ModelDefinition def;

        switch (OpType.of(type)){
          case AND:
          case OR:
            def = mapper.readValue(json, LogicalDefinition.class);
            break;
          case TERN:
            def = mapper.readValue(json, TernaryDefinition.class);
            break;
          case MAP:
            def = mapper.readValue(json, MapParameterDefinition.class);
            break;
          case METH:
            def = mapper.readValue(json, MethodDefinition.class);
            break;
          case VAR:
            def = mapper.readValue(json, ParameterDefinition.class);
            break;
          default:
            def = mapper.readValue(json, ParameterDefinition.class);
        }

        defs.add(def);
      }
    }

    return defs;
  }
}
