// Time: O(n)
// Space: O(1)

public class BruteForce {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }

        }
        return -1;
        
            }
}