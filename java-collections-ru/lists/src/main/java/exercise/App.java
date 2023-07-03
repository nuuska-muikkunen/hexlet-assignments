package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static void main(String[] args){
        // generate letters string
        String stringForTest = "rkqodlw";
        // generate the word
        String wordForTest = "world";
        //get result
        boolean result = scrabble(stringForTest, wordForTest);
        System.out.println(result);
    }
    public static boolean scrabble(String stringForTest, String wordForTest) {
        // make all the letters of lowercase
        String stringToCompare = stringForTest.toLowerCase();
        String wordToCompare = wordForTest.toLowerCase();
        if (stringForTest.length() < wordForTest.length()) {
            return false;
        }
        // Convert String to ArrayList<String> by letters
        List<String> lettersAvailable = new ArrayList<>(stringToCompare.length());
        char[] temporaryCharArray = stringToCompare.toCharArray();
        for (char tempChar: temporaryCharArray) {
            lettersAvailable.add(Character.toString(tempChar));
        }
        // Convert String to Array of Strings by letters
        String[] word = new String[wordToCompare.length()];
        for(int i = 0; i < wordToCompare.length(); i++)
        {
            word[i] = String.valueOf(wordToCompare.charAt(i));
        }
        // Check if every letter in the word is available in the initial set of letters
        // If so, remove every letter available from the initial set of letters
        for (String element: word) {
            if (lettersAvailable.contains(element)) {
                lettersAvailable.remove(element);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
