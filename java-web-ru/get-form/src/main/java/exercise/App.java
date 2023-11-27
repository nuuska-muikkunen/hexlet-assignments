package exercise;

import io.javalin.Javalin;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

public final class App {

    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var term = "";
            var page = new UsersPage(USERS, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users{term}", ctx -> {
            var term = ctx.queryParam("term");
            var user = USERS.stream()
                    .filter(u -> StringUtils.startsWithIgnoreCase(u.getFirstName(), term))
                    .toList();
            var page = new UsersPage(user, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        // END

        app.get("/", ctx -> {
            var term = "";
            var page = new UsersPage(USERS, term);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
