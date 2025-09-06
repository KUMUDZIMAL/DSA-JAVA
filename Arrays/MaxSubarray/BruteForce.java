//Time Complexity:
//O(n²) (two loops for start and end indices).
//Computing subarray sum inside loop is O(1) due to cumulative sum.

//Space Complexity:
// O(1) (no extra space used).


class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }
}
