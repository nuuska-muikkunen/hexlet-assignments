package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.Task;
import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDTO> index() {
        var tasks = taskRepository.findAll();
        return tasks.stream()
                .map(t -> taskMapper.map(t))
                .toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO show(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with id " + id + " not found"));
        var taskDTO = taskMapper.map(task);
        // DTO передает только индекс assignee, нужно вручную устанавливать исполнителя задачи
        taskDTO.setAssigneeId(task.getAssignee().getId());
        return taskDTO;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskCreateDTO taskData) {
        var task = taskMapper.map(taskData);
        var user = userRepository.findById(taskData.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("No user with id " + task.getAssignee().getId() + " found"));
        // назначили задачу пользователю с переданным id
        task.setAssignee(user);
        // добавили задачу исполнителю
        user.addTask(task);
        // сохранили сущности в свои репозитории
        taskRepository.save(task);
        userRepository.save(user);
        return taskMapper.map(task);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO update(@RequestBody TaskUpdateDTO taskData, @PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with title " +  id + " not found"));
        var currentAssignee  = userRepository.findById(task.getAssignee().getId())
                .orElseThrow(()-> new ResourceNotFoundException("User with id "
                        + task.getAssignee().getId()
                        + " not found"));
        //remove task from existing user-assignee
        currentAssignee.removeTask(task);
        //update task
        taskMapper.map(taskData, task);
        //add task to new user-assignee
        var newAssignee = userRepository.findById(taskData.getAssigneeId())
                .orElseThrow(()-> new ResourceNotFoundException("User with id "
                        + taskData.getAssigneeId()
                        + " not found"));
        newAssignee.addTask(task);
        //save user to update his tasks
        userRepository.save(newAssignee);
        //save task
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TaskDTO delete(@PathVariable Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with id " + id + " not found"));
        //remove deleted task from its existing user-assignee
        task.getAssignee().removeTask(task);
        //delete his tasks
        taskRepository.deleteById(id);
        return taskMapper.map(task);
    }
    // END
}
