// Two Optimal Approaches
// By HashSet
// By Sorting


// By HashSet
// Time Complexity: O(n) average (HashSet lookup & insert = O(1))
// Space Complexity: O(n) (storing elements in set)

import java.util.HashSet;
// import java.util.Arrays;
public class Optimal {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
}

// Using Sorting
// Time: O(n log n) (due to sorting)
// Space: O(1) (if sorting in place, else O(n) depending on sort implementation)
    
    //public boolean containsDuplicate(int[] nums) {
    //     Arrays.sort(nums);
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] == nums[i - 1]) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}


