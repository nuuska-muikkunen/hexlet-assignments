package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static void main(String[] args) {
        String sentence = "word text cat apple word map apple word";
        Map<String, Integer> countedWords = getWordCount(sentence);
        String actual = toString(countedWords);
        System.out.println(actual);
    }
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> countedWords = new HashMap<>();
        if (sentence.length() != 0) {
            String[] wordsInSentence = sentence.split(" ");
            for (String str: wordsInSentence) {
                if (countedWords.containsKey(str)) {
                    countedWords.put(str, countedWords.get(str) + 1);
                } else {
                    countedWords.put(str, 1);
                }
            }
        }
        return countedWords;
    }
    public static String toString(Map<String, Integer> dictionary) {
        var temporaryString = new StringBuilder("{");
        if (dictionary.isEmpty()) {
            return "{}";
        }
        for (String key: dictionary.keySet()) {
            temporaryString.append(String.format("\n  %s: %d", key, dictionary.get(key)));
        }
        return temporaryString.append("\n}").toString();
    }
}

//END
