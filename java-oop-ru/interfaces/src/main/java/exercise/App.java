package exercise;

import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> listOfFlatsAndCotages, int amoutOfTopRealEstateObjects) {
        List<String> sortedList = listOfFlatsAndCotages.stream()
                .sorted(Home::compareTo)
                .map(Object::toString)
                .toList();
        int amount = Math.min(amoutOfTopRealEstateObjects, sortedList.size());
        return sortedList.subList(0, amount);
    }
}
// END
