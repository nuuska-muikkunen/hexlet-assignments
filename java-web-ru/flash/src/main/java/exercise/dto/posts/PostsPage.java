package exercise.dto.posts;

import java.util.List;

import exercise.dto.BasePage;
import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostsPage extends BasePage {
    public List<Post> posts;
}
