// Given a string, find the length of the longest substring which has no duplicate character

package String;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println("Length of substring without repeating character: " + lengthOfLongestSubstring(s));
    }

    static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int maxCount = 0;

        int i = 0, j = 0;

        while (j < s.length()) {
            if (indexMap.containsKey(s.charAt(j))) {
                i = Math.max(indexMap.get(s.charAt(j)), i);
            }

            maxCount = Math.max(maxCount, j - i + 1);
            indexMap.put(s.charAt(j), j + 1);
            j += 1;
        }

        return maxCount;
    }
}
