package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> tempMap = new HashMap<>(storage.toMap());
        for (String key: tempMap.keySet()) {
            storage.set(tempMap.get(key), key);
            storage.unset(key);
        }
    }
}
// END
