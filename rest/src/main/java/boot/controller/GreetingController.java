package boot.controller;

import java.util.concurrent.atomic.AtomicLong;

import boot.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "hello %s";
	private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {

      return new Greeting(this.counter.incrementAndGet(), String.format(template,name));

    }

}


