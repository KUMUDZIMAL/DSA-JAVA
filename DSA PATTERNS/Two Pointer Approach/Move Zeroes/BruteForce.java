import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
       List<Integer> copy =new ArrayList<>();
     for(int i=0;i<n;i++){
            if(nums[i]==0){
             continue;
          
             }
             else{
                copy.add(nums[i]);
             }
        }
             for(int i=0;i<copy.size();i++){
            
                nums[i]=copy.get(i);
             }

              for(int i=copy.size();i<n;i++){
            
                nums[i]=0;
             }
    }
}