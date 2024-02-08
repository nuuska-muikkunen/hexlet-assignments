package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        HashMap<String, Integer> result = new HashMap<>();
        var max = new MaxThread(numbers);
        var min = new MinThread(numbers);
        max.run();
        min.run();
//        max.interrupt();
//        min.interrupt();
        result.put("min", min.getMinimum());
        result.put("max", max.getMaximum());
        return result;
    }
    // END
}
