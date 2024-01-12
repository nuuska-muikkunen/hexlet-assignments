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
        return ResponseEntity.status(HttpStatus.OK).body(Optional.of(result));
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable Integer id,
                                       @RequestBody Post post) {
        var newPost = new Post();
        newPost.setUserId(id);
        newPost.setSlug(post.getSlug());
        newPost.setTitle(post.getTitle());
        newPost.setBody(post.getBody());
        posts.add(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }

}
// END
