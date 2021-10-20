package medianotes.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class LoginController {

    @PostMapping("/registration")
    public String registration() {
        return "Ok!";
    }
}
