package learning_app.controller;

import learning_app.service.LearningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LearningController {
  
  LearningService learningService;

  public LearningController(LearningService learningService) {
    this.learningService = learningService;
  }

  @GetMapping("/hello")
  public String hello() {
    String response = learningService.getHtmlFile();
    log.warn("Response: {}", response);
    return response;
  }
  
}
