// Out of n versions of a product, the first bad version needs to be determined after which all the versions are bad

package BinarySearch;

public class FirstBadVersion {
    static int FIRST_BAD_VERSION = 4;

    static boolean isBadVersion(int n) {
        return !(n < FIRST_BAD_VERSION);
    }

    static int firstBadVersion(int n) {
        int start = 1, end = n, mid = 0;

        while (start < end) {
            mid = start + (end - start) / 2;

            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }

        return end;
    }

    public static void main(String[] args) {
        int version = 5;

        System.out.println("First Bad Version: " + firstBadVersion(version));
    }

}
