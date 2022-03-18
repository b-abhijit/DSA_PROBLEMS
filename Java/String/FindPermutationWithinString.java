// Given two string s1 & s2, check if s2 contains a possible permutation of s1

package String;

public class FindPermutationWithinString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";

        System.out.println("Does s2 contain permutation of s1 ?: " + checkPermutation(s1, s2));
    }

    static boolean checkPermutation(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] arr1 = new int[26], arr2 = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            arr1[s1.charAt(i) - 97] += 1;
            arr2[s2.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < s2.length() - s1.length(); ++i) {
            if (findPermutation(arr1, arr2))
                return true;

            arr2[s2.charAt(i + s1.length()) - 97] += 1;
            arr2[s2.charAt(i) - 97] -= 1;
        }

        return findPermutation(arr1, arr2);
    }

    static boolean findPermutation(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; ++i) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }
}
