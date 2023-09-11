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
            tempMap.put(key, tempMap.get(key));
            tempMap.remove(key);
        }
//        for (Map.Entry<String, String> entry : tempMap.entrySet()) {
//            storage.set(entry.getKey(), entry.getValue());
//        }
    }
}
// END
