import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1;j<n-2;j++){
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            int left=j+1;
            int right=n-1;
           while(left<right){
            long sum=(long) nums[left]+nums[right]+nums[i]+nums[j];
            if(sum==target){
              ans.add(Arrays.asList(nums[i],nums[left],nums[right],nums[j]));
        
            left++;
              right--;

        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }
                }
           
             if (sum<target){
             left++;
            }
            if(sum>target){
                right--;
            }
           }
        }}
        return ans;
    }
}