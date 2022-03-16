// To generate all possible permutations of a string

package String;

import java.util.List;

public class FindAllPermutations {
    public static void main(String[] args) {
        String str = "abc";
        permute(str, 0, str.length());
    }

    static void permute(String str, int lIndex, int rIndex) {
        if (lIndex == rIndex) {
            System.out.println(str);
            return;
        } else{
            for (int i = lIndex; i < rIndex; ++i) {
                str = new String(swap(str, i, lIndex));
                permute(str, lIndex + 1, rIndex);
                str = new String(swap(str, i, lIndex));
            }
        }
    }

    static String swap(String str, int i, int j) {
        char ch = str.charAt(i);
        str = str.substring(0, i) + str.charAt(j) + str.substring(i + 1);
        str = str.substring(0, j) + ch + str.substring(j + 1);
        return str;
    }
}
