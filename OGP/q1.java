import java.util.*;

class Solution {
    
    public void run() {
        // test case 1
        String s = "Hello my name is <firstname> <lastname> child of <father>";
        Hashtable<String, String> m = new Hashtable<>();
        m.put("firstname", "Luke");
        m.put("lastname", "Skywalker");
        m.put("father", "Anakin");

        // test case 2
        // String s = "hello <> world";
        // empty hashtable
        
        // test case 3 - word after '>', and dummy '>'
        // String s = "Hello my name is <firstname> <lastname> child of <father> word after >.";
        // m.put("firstname", "Luke");
        // m.put("lastname", "SKywalker");
        // m.put("father", "Anakin");
        
        StringBuilder toBeIterated = new StringBuilder(s);
        StringBuilder wordToBeReplaced = new StringBuilder();
        StringBuilder result = new StringBuilder();

        boolean replacingWord = false;
        for (int i = 0; i < toBeIterated.length(); i++) {
            char cur = toBeIterated.charAt(i);
            if (!replacingWord) {
                if (cur == '<') {
                    replacingWord = true;
                } else {
                    result.append(cur);
                }
            } else {
                if (cur == '>') {
                    String replacedWord = m.get(wordToBeReplaced.toString());
                    if (replacedWord == null) {
                        replacedWord = "";
                    }
                    result.append(replacedWord);
                    wordToBeReplaced = new StringBuilder();
                    replacingWord = false;
                } else {
                    wordToBeReplaced.append(cur);
                }
            }
        }


        System.out.println(result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.run();
    }
}
