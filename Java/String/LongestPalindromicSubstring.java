// Given a string, find the longest palindromic substring

package String;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "abcpca";

//        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring(input));
//        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstringOptimized(input));
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstringDP(input));
    }

    // Brute Force Approach
    static String longestPalindromicSubstring(String s) {
        int counter = 1;
        String result = String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length(); ++i) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); ++j) {
                sb.append(s.charAt(j));
                if (isPalindrome(sb.toString()) && sb.length() > counter) {
                    counter = sb.length();
                    result = sb.toString();
                }
            }
        }

        return result;
    }

    // Optimized Approach
    static String longestPalindromicSubstringOptimized(String s) {
        int counter = 1;
        StringBuilder result = new StringBuilder();
        int[] arr = new int[2];

        for (int i = 0; i < s.length(); ++i) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > counter) {
                    counter = right - left + 1;
                    arr[0] = left;
                    arr[1] = right;
                }
                left -= 1;
                right += 1;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > counter) {
                    counter = right - left + 1;
                    arr[0] = left;
                    arr[1] = right;
                }
                left -= 1;
                right += 1;
            }
        }

        while (arr[0] <= arr[1]) {
            result.append(s.charAt(arr[0]));
            arr[0] += 1;
        }

        return result.toString();
    }

    // Dynamic Programming Approach
    static String longestPalindromicSubstringDP(String s) {
        int[][] result = new int[s.length()][s.length()];
        int[] arr = new int[2];
        int counter = 0;
        StringBuilder answer = new StringBuilder();

        for (int gap = 0; gap < s.length(); ++gap) {
            for (int left = 0, right = gap; right < s.length(); ++left,++right) {
//                System.out.println(s.substring(i, j + 1));
                if (gap == 0)
                    result[left][right] = 1;
                else if (gap == 1) {
                    if (s.charAt(left) == s.charAt(right))
                        result[left][right] = 1;
                } else {
                    if (s.charAt(left) == s.charAt(right) && result[left + 1][right - 1] == 1)
                        result[left][right] = 1;
                }

                if (result[left][right] == 1 && right - left + 1 > counter) {
                    counter = right - left + 1;
                    arr[0] = left;
                    arr[1] = right;
                }
            }
        }

        while (arr[0] <= arr[1]) {
            answer.append(s.charAt(arr[0]));
            arr[0] += 1;
        }

        return answer.toString();
    }

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i != j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
