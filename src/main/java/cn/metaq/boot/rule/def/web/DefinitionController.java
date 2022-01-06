package cn.metaq.boot.rule.def.web;

import cn.metaq.boot.rule.def.model.dto.ModelDTO;
import cn.metaq.common.web.dto.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefinitionController {

  @PostMapping("build")
  public Result build(@RequestBody List<ModelDTO> def){

    return Result.ok(def.stream().map(s->{

      Map<String,Object> m=new HashMap<>();
      m.put("targetId",s.getTargetId());
      m.put("targetType",s.getTargetType());
      m.put("bizType",s.getBizType());
      m.put("rule",s.getRule().build().build());
      return m;
    }));
  }
}
