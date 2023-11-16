package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.lang.String;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;

import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/", ctx -> {
            ctx.result("Try to use /users/[1 ... 30]");
        });

        app.get("/users", ctx -> {
            var users = Data.getUsers();/* Список пользователей извлекается из базы данных */
            var header = "Users output";
            var page = new UsersPage(users, header);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var userId = ctx.pathParamAsClass("id", Integer.class).get();
            User result = new User(0, "", "", "");
            for (User m : USERS) {
                if (m.getId() == userId){
                    result = new User(m.getId(), m.getFirstName(), m.getLastName(), m.getEmail());
                }
            }
            if (result.getId() == 0) {
                throw new NotFoundResponse("User not found");
            } else {
                var header = "User output";
                var page = new UserPage(result, header);
                ctx.render("users/show.jte", Collections.singletonMap("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
