package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 声明控制器，但实际对 Spring MVC 本身的影响不大
@RequestMapping("/")
public class HomeController {
  @RequestMapping(method = GET)
  public String home(Model model) {
    return "home";
  }
}
