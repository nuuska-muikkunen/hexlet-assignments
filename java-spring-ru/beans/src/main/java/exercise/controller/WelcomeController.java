package exercise.controller;

import exercise.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;

// BEGIN


@RestController
@RequestScope
public class WelcomeController {
    @Autowired
    private Application application;

    @GetMapping(path = "/welcome")
    public String Welcome() {
        return application.dayTime();
    }
}
// END
