package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static void main(String[] args) {
        String test = "[foo:bar]environment=\"X_FORWARDED_var1=111\"[bar:baz]";
        System.out.println(getForwardedVariables(test));
    }
    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("envi"))
                .filter(s -> s.startsWith("ronment="))
                .flatMap(line -> Stream.of(line.split("X_FOR")))
                .filter(s -> s.startsWith("WARDED_"))
                .map(s -> s.substring(7, s.indexOf(s.contains(",") ? "," : "\"")))
                .collect(Collectors.joining(","));
    }
}
//END
