package exercise;

import java.util.*;

// BEGIN
class App {
    public static void main(String[] args) {
    Map<String, Object> data1 = new HashMap<>(Map.of("one", "eon", "two", "two", "four", true));
    System.out.println(data1); //=> {two=two, four=true, one=eon}
    Map<String, Object> data2 = new HashMap<>(Map.of("two", "own", "zero", 4, "four", true));
    System.out.println(data2); //=> {zero=4, two=own, four=true}

    Map<String, String> result = App.genDiff(data1, data2);
    System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }
    public static LinkedHashMap genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        return (LinkedHashMap) result;
    }
}
//END
