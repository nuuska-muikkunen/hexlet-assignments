package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;
    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var car = new Car(this.id, this.brand, this.model, this.color, this.owner);
        return mapper.writeValueAsString(car);
    }
    public static Car unserialize(String carInJsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(carInJsonString, Car.class);
        return car;
    }
    // END
}
