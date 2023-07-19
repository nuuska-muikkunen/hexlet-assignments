package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static void main(String[] args) {
        String[] emails = {
            "info@gmail.com",
            "info@yandex.ru",
            "mk@host.com",
            "support@hexlet.io",
            "info@hotmail.com",
            "support.yandex.ru@host.com"
        };
        List<String> listOfAddresses = new ArrayList<>(List.of(emails));
        System.out.println(getCountOfFreeEmails(listOfAddresses));
    }
    public static long getCountOfFreeEmails(List<String> addresses) {
        List<String> freeDomains = new ArrayList<>();
        freeDomains.add("gmail.com");
        freeDomains.add("yandex.ru");
        freeDomains.add("hotmail.com");
        return addresses.stream()
                .map(str -> str.substring(str.indexOf('@') + 1))
                .filter(str -> freeDomains.contains(str))
                .count();
    }
}
// END
