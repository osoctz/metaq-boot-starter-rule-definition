package cn.metaq.boot.rule.def.web;

import cn.metaq.boot.rule.def.model.dto.ModelDTO;
import cn.metaq.common.web.dto.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefinitionController {

  @PostMapping("build")
  public Result build(@RequestBody ModelDTO def){

    return Result.ok(def.getRule().build().build());
  }
}
