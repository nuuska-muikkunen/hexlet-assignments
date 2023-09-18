package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path pathToCarData, Car car) throws IOException {
        Car carInString = new Car(car.getId(), car.getBrand(), car.getModel(), car.getColor(), car.getOwner());
        Files.writeString(pathToCarData, carInString.serialize());
    }
    public static Car extract(Path pathToCarFile) throws IOException {
        String carString = Files.readString(pathToCarFile);
        var car = Car.unserialize(carString);
        return car;
    }
}
// END
