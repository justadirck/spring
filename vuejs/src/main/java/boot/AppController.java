package boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("eventName", "FIFA 2023");
        return "index2";
    }
    
}