package exercise;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

// BEGIN
class App {
    public static void main(String[] args) {
        List<Map<String, String>> books = new ArrayList<>();
        Map<String, String> book1 = Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611");
        Map<String, String> book2 = Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111");
        Map<String, String> book3 = Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611");
        Map<String, String> book4 = Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222");
        Map<String, String> book5 = Map.of("title", "Still foooing", "author", "FooBar", "year", "3333");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        System.out.println(books);
        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));
        List<Map<String, String>> result = findWhere(books, where);
        System.out.println("result " + result + "\nof search " + where);
    }
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> booksFound = new ArrayList<>();
        for (Map<String, String> book : books) {
            if (isInBook(book, where)) {
                booksFound.add(book);
            }
        }
        return booksFound;
    }
    public static boolean isInBook(Map<String, String> whereIncluded, Map<String, String> whatIncluded) {
        for (String keyWhere: whereIncluded.keySet()) {
            for (String keyWhat : whatIncluded.keySet()) {
                if (!whereIncluded.containsKey(keyWhat) || !whereIncluded.containsValue(whatIncluded.get(keyWhat))) {
                    return false;
                }
            }
        }
        return true;
    }
}
//END
