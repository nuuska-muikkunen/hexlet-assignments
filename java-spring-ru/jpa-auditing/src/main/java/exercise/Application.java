package exercise;

import exercise.controller.TasksController;
import exercise.model.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// BEGIN
@EnableJpaAuditing
// END
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        TasksController tasksController = new TasksController();

        Task task1 = new Task();
        task1.setTitle("first");
        task1.setDescription("first test task");
        System.out.println(task1.toString());
        tasksController.create(task1);

        Task task2 = new Task();
        task2.setTitle("second");
        task2.setDescription("second test task");
        tasksController.create(task2);
        System.out.println(task2.toString());
        System.out.println(tasksController.index());

        tasksController.update(1L, task2);
        System.out.println(tasksController.index());
    }
}
