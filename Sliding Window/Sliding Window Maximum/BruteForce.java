
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
       for(int i=0;i<n-k+1;i++){
            int maxi=nums[i];
        for(int j=i;j<=i+k-1;j++){
        maxi=Math.max(nums[j],maxi);

        }
        result[i]=maxi;
       }
       return result;
    }}