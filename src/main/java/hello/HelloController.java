package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

  private Logger log = LoggerFactory.getLogger(HelloController.class);

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/user/{id}")
  public String user(@PathVariable Integer id){
    return "Integer: " + id;
  }

  @RequestMapping("/path/{partialPath:.+}")
  public String path(@PathVariable String partialPath) {
    return "PartialPath: " + partialPath;
  }

  @RequestMapping("/regexp/{id}/**")
  public String regexp(@PathVariable String id, HttpServletRequest request) {
    log.info("PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE: {}", request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
    log.info("BEST_MATCHING_PATTERN_ATTRIBUTE: {}", request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE));
    log.info("INTROSPECT_TYPE_LEVEL_MAPPING: {}", request.getAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING));
    log.info("URI_TEMPLATE_VARIABLES_ATTRIBUTE: {}", request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
    log.info("MATRIX_VARIABLES_ATTRIBUTE: {}", request.getAttribute(HandlerMapping.MATRIX_VARIABLES_ATTRIBUTE));
    log.info("PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE: {}", request.getAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE));
    return "Regexp: " + id;
  }

}
