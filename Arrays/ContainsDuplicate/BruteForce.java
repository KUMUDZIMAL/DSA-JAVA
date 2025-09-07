// Time: O(n²) → two nested loops
// Space: O(1)

public class BruteForce {

        public boolean containsDuplicate(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }


}
