package cn.metaq.boot.rule.def;

import cn.metaq.boot.rule.def.model.dto.LogicalDefinition;
import cn.metaq.boot.rule.def.model.dto.MethodDefinition;
import cn.metaq.boot.rule.def.model.dto.TernaryDefinition;
import cn.metaq.common.util.JsonUtils;
import java.io.IOException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class ModelDefinitionTests {

  private static final Logger logger=LoggerFactory.getLogger(ModelDefinitionTests.class);

  @Test
  public void testMethodBuilder() throws IOException {

    Resource resource = new ClassPathResource("sim_method.json");
    MethodDefinition def=JsonUtils.fromJson(resource.getInputStream(), MethodDefinition.class);
    logger.info("===def===:{}", ToStringBuilder.reflectionToString(def, ToStringStyle.JSON_STYLE));
  }

  @Test
  public void testLogicalBuilder() throws IOException {

    Resource resource = new ClassPathResource("sim_logical.json");
    LogicalDefinition def=JsonUtils.fromJson(resource.getInputStream(), LogicalDefinition.class);
    logger.info("===def===:{}", ToStringBuilder.reflectionToString(def, ToStringStyle.JSON_STYLE));

    logger.info("===SpEL====:{}",def.build().build());
  }

  @Test
  public void testOrBuilder() throws IOException {

    Resource resource = new ClassPathResource("or_logical.json");
    LogicalDefinition def=JsonUtils.fromJson(resource.getInputStream(), LogicalDefinition.class);
    logger.info("===def===:{}", ToStringBuilder.reflectionToString(def, ToStringStyle.JSON_STYLE));
  }

  @Test
  public void testTernBuilder() throws IOException {

    Resource resource = new ClassPathResource("sim_ternary.json");
    TernaryDefinition def=JsonUtils.fromJson(resource.getInputStream(), TernaryDefinition.class);
    logger.info("===def===:{}", ToStringBuilder.reflectionToString(def, ToStringStyle.JSON_STYLE));
  }

  @Test
  public void testCompositeTernBuilder() throws IOException {

    Resource resource = new ClassPathResource("composite.json");
    TernaryDefinition def=JsonUtils.fromJson(resource.getInputStream(), TernaryDefinition.class);
    //logger.info("===def===:{}",JsonUtils.toJson(def));
    logger.info("===SpEL=:{}",def.build().build());
  }

  @Test
  public void testAndBuilder() throws IOException {

    Resource resource = new ClassPathResource("list_logical.json");
    LogicalDefinition def=JsonUtils.fromJson(resource.getInputStream(), LogicalDefinition.class);
    logger.info("===def===:{}", ToStringBuilder.reflectionToString(def, ToStringStyle.JSON_STYLE));
    logger.info("===json=:{}",JsonUtils.toJson(def));
  }
}
