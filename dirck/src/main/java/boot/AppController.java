package boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@GetMapping(path = "/")
	public @ResponseBody String root() {
		return "dirck ok";
	}

}
