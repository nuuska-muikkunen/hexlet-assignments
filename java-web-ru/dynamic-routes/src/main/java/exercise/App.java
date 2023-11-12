package exercise;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var companyId = ctx.pathParam("id");
            Map<String, String> result = new HashMap<>();
//            var result = COMPANIES.stream().filter(m -> m.get("id").equals(companyId))
//                    .peek(System.out::println)
//                    .toString();
            for (Map<String, String> m : COMPANIES) {
                if (m.get("id").equals(companyId)) {
                    result.putAll(m);
                }
            }
            if (result.isEmpty()) {
                throw new NotFoundResponse("Company not found");
            } else {
                ctx.json(result);
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
