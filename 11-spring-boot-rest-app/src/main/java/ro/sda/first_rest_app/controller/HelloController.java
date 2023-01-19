package ro.sda.first_rest_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.first_rest_app.model.Person;

@RestController
public class HelloController {

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable("name") String name) {
    return "Hello, " + name + "!";
  }

  @GetMapping("/other-hello")
  public String helloQueryParam(@RequestParam("name") String name) {
    return "Hello, " + name + "!";
  }

  @GetMapping("/goodbye")
  public String goodbye(@RequestHeader("name") String name) {
    return "Goodbye, " + name + "!";
  }

  @PostMapping("/solong")
  public String solong(@RequestBody Person p) {
    return "So long, " + p.getName() + "!";
  }
  
  
}
