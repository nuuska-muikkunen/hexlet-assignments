package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> map = new HashMap<>();
    InMemoryKV(Map<String, String> map) {
        this.map.putAll(map);
    }
    @Override
    public void set(String key, String value) {
        this.map.put(key, value);
    }
    @Override
    public void unset(String key) {
        this.map.remove(key);
    }
    @Override
    public String get(String key, String defaultValue) {
        return this.map.getOrDefault(key, defaultValue);
    }
    @Override
    public Map<String, String> toMap() {
        Map<String, String> tempMap = new HashMap<String, String> (this.map);
        return tempMap;
    }
}
// END
