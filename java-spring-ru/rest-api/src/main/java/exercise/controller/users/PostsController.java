package exercise.controller.users;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();
    @GetMapping("/users/{id}/posts")
    public ResponseEntity<Optional<List<Post>>> index(@PathVariable Integer id) {
        var result = posts.stream()
                .filter(post -> post.getUserId() == id)
                .toList();
        return ResponseEntity.status(201).body(Optional.of(result));
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> create(@PathVariable Integer id,
                                       @RequestParam String slug,
                                       @RequestParam String title,
                                       @RequestParam String body) {
        var newPost = new Post();
        newPost.setUserId(id);
        newPost.setSlug(slug);
        newPost.setTitle(title);
        newPost.setBody(body);
        posts.add(newPost);
        return ResponseEntity.ok(newPost);
    }

}
// END
