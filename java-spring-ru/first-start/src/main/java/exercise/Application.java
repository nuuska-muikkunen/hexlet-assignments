package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/about")
    public String hello(@RequestParam(value = "name", defaultValue = "Hexlet") String name) {
        return String.format("Welcome to %s!", name);
    }
}
// END
