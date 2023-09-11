package exercise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private Map<String, String> map;
    private String pathToFile;

    public FileKV(Map<String, String> map, String pathToFile) {
        this.map = map;
        this.pathToFile = pathToFile;
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
        return this.map;
    }
    public void writeFileKV(KeyValueStorage database, String pathToFile) {
        String mapInString = Utils.serialize(database.toMap());
        String absoluteFilePath = Paths.get(pathToFile).toAbsolutePath().normalize().toString();
        Utils.writeFile(absoluteFilePath, mapInString);
    }
    public String readFileKV(String pathToFile) {
        //String mapInString = Utils.serialize(database.toMap());
        //String absoluteFilePath = Paths.get(pathToFile).toAbsolutePath().normalize().toString();
        return Utils.readFile(pathToFile);
    }
}
// END
