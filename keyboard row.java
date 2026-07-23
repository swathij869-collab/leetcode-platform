import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        int[] row = new int[26];

        // First row
        for (char c : "qwertyuiop".toCharArray()) {
            row[c - 'a'] = 1;
        }

        // Second row
        for (char c : "asdfghjkl".toCharArray()) {
            row[c - 'a'] = 2;
        }

        // Third row
        for (char c : "zxcvbnm".toCharArray()) {
            row[c - 'a'] = 3;
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int currentRow = row[lower.charAt(0) - 'a'];

            boolean valid = true;

            for (char c : lower.toCharArray()) {
                if (row[c - 'a'] != currentRow) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
