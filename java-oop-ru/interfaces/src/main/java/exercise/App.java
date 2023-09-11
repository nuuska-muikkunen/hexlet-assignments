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
         // new
//        public static List<String> buildApartmentsList(List<Home> apartments, int count) {
//            return apartments.stream()
//                    .sorted(Home::compareTo)
//                    .limit(count)
//                    .map(Home::toString)
//                    .toList();
//        }
        // old
//        public static List<String> buildApartmentsList2(List<Home> apartments, int count) {
//            int normalizedCount = Math.min(count, apartments.size());
//            apartments.sort(Home::compareTo);
//            List<Home> sublist = apartments.subList(0, normalizedCount);
//            return sublist.stream()
//                    .map(appartment -> appartment.toString())
//                    .collect(Collectors.toList());
//        }
//    }
}
// END
