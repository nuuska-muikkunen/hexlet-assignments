package exercise;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        List<String> result = new ArrayList<>();
        result = users.stream()
                .filter(s -> s.get("gender").equals("male"))
                .sorted((date1, date2) -> date1.get("birthday").compareTo(date2.get("birthday")))
                .map(s -> s.getOrDefault("name", "no element"))
                .collect(Collectors.toList());
        return result;
    }
}

// END
