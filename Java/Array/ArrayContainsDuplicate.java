// Find if in an array any value appears at least twice

package Array;

import java.util.HashSet;

public class ArrayContainsDuplicate {
    public static void main(String[] args) {
        int nums[] = {1,1,1,3,3,4,3,2,4,2};
        boolean status = false;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                status = true;
                break;
            }
            set.add(nums[i]);
        }

        System.out.println(status);
    }
}
