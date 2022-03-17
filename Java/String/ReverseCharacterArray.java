// Reverse a given character array

package String;

import java.util.Arrays;

public class ReverseCharacterArray {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        int i = 0, j = s.length - 1;

        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i += 1;
            j -= 1;
        }

        System.out.println(Arrays.toString(s));
    }
}
