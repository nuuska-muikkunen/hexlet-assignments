package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void rootPage(Context ctx) {
        var user = ctx.sessionAttribute("currentUser");
        var page = new MainPage(user);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("name");
        var password = ctx.formParam("password");
        // Проверка пароля
        if (UsersRepository.findByName(nickname) == null
                || !UsersRepository.findByName(nickname).getPassword().equals(encrypt(password))) {
            var page = new LoginPage(nickname, "Wrong username or password");
            ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
        } else {
            ctx.sessionAttribute("currentUser", nickname);
            var page = new MainPage(nickname);
            ctx.render("index.jte", Collections.singletonMap("page", page));
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
