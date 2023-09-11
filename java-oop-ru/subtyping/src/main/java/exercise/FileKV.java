package exercise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private Map<String, String> map = new HashMap<>();
    private String pathToFile;

    FileKV(String pathToFile, Map<String, String> map) {
        this.map.putAll(map);
        this.pathToFile = pathToFile;
        Map<String, String> tempMap = new HashMap<>(map);
        String mapInString = Utils.serialize(tempMap);
        String absoluteFilePath = Paths.get(this.pathToFile).toAbsolutePath().normalize().toString();
        Utils.writeFile(absoluteFilePath, mapInString);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> tempMap = new HashMap<>(this.map);
        return tempMap;
    }
//    public static void writeFileKV(KeyValueStorage map, String pathToFile) {
//        String mapInString = Utils.serialize(map.toMap());
//        String absoluteFilePath = Paths.get(pathToFile).toAbsolutePath().normalize().toString();
//        Utils.writeFile(absoluteFilePath, mapInString);
//    }
//    public static String readFileKV(String pathToFile) {
//        return Utils.readFile(pathToFile);
//    }
}
// END
