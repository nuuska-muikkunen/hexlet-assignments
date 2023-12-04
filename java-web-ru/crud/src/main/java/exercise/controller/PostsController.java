package exercise.controller;

import java.util.ArrayList;
import java.util.Collections;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var page = new PostsPage(posts, 0L);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void paging(Context ctx) {
        var pageNumber = ctx.queryParam("page");
        if (pageNumber == null) {
            pageNumber = String.valueOf(1L);
        }
        var posts = PostRepository.getEntities();
        var singlePage = new ArrayList<Post>();
        for (int i = 0; i < 5; i++) {
            singlePage.add(posts.get((Integer.parseInt(pageNumber) - 1) * 5 + i));
        }
        var page = new PostsPage(singlePage, Long.valueOf(pageNumber));
        ctx.render("posts/page.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
