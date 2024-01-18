package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Day;
import exercise.daytime.Night;

// BEGIN
import org.springframework.context.annotation.Bean;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    public String dayTime() {
        var dayTime = LocalDateTime.now().getHour() > 6 && LocalDateTime.now().getHour() <= 22
                ? new Day() : new Night();
        return "It is " + dayTime.getName() + " now! Welcome to Spring!";
    }

    // END
}
