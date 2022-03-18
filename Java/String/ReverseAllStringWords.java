// Given a string reverse all the words in it

package String;

public class ReverseAllStringWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
    }

    static public String reverseWords(String s) {
        if (s.length() == 1)
            return s;

        int i = 0, j = 0;

        while (i < s.length()) {
            j = s.indexOf(' ', j + 1);
            if (j == -1)
                j = s.length();

            s = reverseString(s, i, j - 1);
            i = j + 1;
        }

        return s;
    }

    static String reverseString(String str, int from, int to) {
        char[] charArray = str.toCharArray();
        while(from < to) {
            char ch = charArray[from];
            charArray[from] = charArray[to];
            charArray[to] = ch;
            from += 1;
            to -= 1;
        }
        return String.valueOf(charArray);
    }
}
