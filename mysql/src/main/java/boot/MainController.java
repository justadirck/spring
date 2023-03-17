package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {
  
  @Autowired 
  private PersonRepository personRepository;

  @PostMapping(path="/add") 
  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
    Person p = new Person();
    p.setName(name);
    p.setEmail(email);
    this.personRepository.save(p);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Person> getAllUsers() {
    return this.personRepository.findAll();
  }

}