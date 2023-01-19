package learning_app.service.impl;

import learning_app.service.LearningService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("learning")
public class LearningServiceImpl implements LearningService {
  @Override
  public String getHtmlFile() {
    return "learning.html";
  }
}
