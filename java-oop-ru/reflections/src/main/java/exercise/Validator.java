package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) throws IllegalAccessException {
        List<String> list = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                if (field.get(address) == null) {
                    list.add(field.getName());
                }
            }
        }
        return list;
    }

    public static HashMap<String, ArrayList<String>> advancedValidate(Address address) throws IllegalAccessException {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        map.put("NotNull", new ArrayList<String>());
        map.put("MinLength", new ArrayList<String>());
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                if (field.get(address) == null) {
                    map.get("NotNull").add("can not be null");
                }
            }
            if (field.isAnnotationPresent(MinLength.class) && field.get(address) != null) {
                field.setAccessible(true);
                MinLength min = field.getAnnotation(MinLength.class);
                if (field.get(address).toString().length() < min.minLength()) {
                    map.get("MinLength").add("length less than 4");
                }
            }
        }
        return map;
    }
}
// END
