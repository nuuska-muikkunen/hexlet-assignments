package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() { return "/posts";}
    public static String postPath(String id) {
        return "/posts/" + id;
    }
    public static String postPath(Long id) { return postPath(String.valueOf(id)); }
    public static String pagesPath() {
        return "/posts?page=0";
    }
    public static String pagePath(String page) { return "/posts/" + page; }
    public static String pagePath(Long page) { return postPath(String.valueOf(page)); }
    // END
}
