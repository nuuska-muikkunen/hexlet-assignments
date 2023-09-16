package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;
import java.util.*;

import exercise.Validator;


class ValidationTest {

    @Test
    void testValidate() throws IllegalAccessException {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate() throws IllegalAccessException {
        Address address1 = new Address("USA", "Texas", null, "7", "2");
        var result1 = Validator.advancedValidate(address1);
        List<String> arr1 = new ArrayList<>();
        arr1.add("length less than 4");
        List<String> arr2 = new ArrayList<>();
        arr2.add("can not be null");
        HashMap<String, List<String>> expected1 = new HashMap<>();
        expected1.put("MinLength", arr1);
        expected1.put("NotNull", arr2);
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address("GreatBritain", "London", "1-st street", "5", "1");
        HashMap<String, ArrayList<String>> result2 = Validator.advancedValidate(address2);
        List<String> arr3 = new ArrayList<>();
        //arr3.add("length less than 4");
        List<String> arr4 = new ArrayList<>();
        //arr4.add("can not be null");
        HashMap<String, List<String>> expected2 = new HashMap<>();
        expected2.put("MinLength", arr3);
        expected2.put("NotNull", arr4);
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address(null, null, null, null, "1");
        HashMap<String, ArrayList<String>> result3 = Validator.advancedValidate(address3);
        List<String> arr5 = new ArrayList<>();
        List<String> arr6 = new ArrayList<>();
        arr6.add("can not be null");
        arr6.add("can not be null");
        arr6.add("can not be null");
        arr6.add("can not be null");
        HashMap<String, List<String>> expected3 = new HashMap<>();
        expected3.put("MinLength", arr5);
        expected3.put("NotNull", arr6);
        assertThat(result3).isEqualTo(expected3);
    }
    // END
}
