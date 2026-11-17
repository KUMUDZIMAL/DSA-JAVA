class Solution {
    public int maxSubArray(int[] nums) {
            // DP space-optimized version
        // int currSum=0;
        // int maxSum=nums[0];
        // for(int i=0;i<nums.length;i++){
        //     currSum=Math.max(nums[i],currSum+nums[i]);
        //     maxSum=Math.max(maxSum,currSum);

        // }
        // return maxSum;

             // DP Tabulation
        int n = nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int maxSum=dp[0];

        for(int i=1;i<n;i++) {
        dp[i]=Math.max(nums[i]+dp[i-1],nums[i]);
        maxSum=Math.max(maxSum,dp[i]);
        }

        return maxSum;
    }
}