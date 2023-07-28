package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;

// BEGIN
class App {
    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>(Map.of("one", "eon", "two", "two", "four", true));
        Map<String, Object> data2 = new HashMap<>(Map.of("two", "own", "zero", 4, "four", true));
        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result);
    }
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> united = new HashSet<>(data1.keySet());
        Set<String> intersection = new HashSet<>(data1.keySet());
        Set<String> difference = new HashSet<>(data1.keySet());
        united.addAll(data2.keySet());
        intersection.retainAll(data2.keySet());
        difference.removeAll(data2.keySet());
        for (String s: united) {
            if (intersection.contains(s)) {
                result.put(s, data1.get(s).equals(data2.get(s)) ? "unchanged" : "changed");
            } else {
                result.put(s, difference.contains(s) ? "deleted" : "added");
            }
        }
        TreeMap<String, String> sorted = new TreeMap<>(result);
        result.clear();
        result.putAll(sorted);
        return result;
    }
}
//END
