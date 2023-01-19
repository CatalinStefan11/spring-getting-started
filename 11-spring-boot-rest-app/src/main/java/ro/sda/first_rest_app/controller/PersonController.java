package ro.sda.first_rest_app.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.first_rest_app.model.Person;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
  
  @RequestMapping(method = RequestMethod.GET, path = "/get")
  public Person getPerson(HttpServletResponse response) {
    
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    Person p = new Person();
    p.setName("Bill");
    return p;
  
  }

  @GetMapping("/get-entity")
  public ResponseEntity<Person> getPersonEntity() {
  
    Person p = new Person();
    p.setName("Bill");
    return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
  
  }



}
