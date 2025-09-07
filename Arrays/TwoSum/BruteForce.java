 // Time Complexity: O(n²)
// Outer loop runs n times.
// Inner loop runs up to n times in worst case.
// Total = n * n = n².

// Space Complexity: O(1)
// No extra data structures are used (only a few variables).

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {}; 
    }
}
