class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int n=nums.length;
     
       int minLen=Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
        int sum=0;
        int l=0;
         for(int j=i;j<n;j++){
            sum+=nums[j];
            l++;
         

        if(sum>=target){
         minLen=Math.min(minLen,l);  
        }
       }
 
    }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
}}