package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void rootPage(Context ctx) {
        ctx.render("index.jte");
    }

    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("nickname");
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
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}
