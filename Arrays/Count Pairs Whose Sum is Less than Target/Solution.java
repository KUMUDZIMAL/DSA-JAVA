import java.util.*;
// Brute Force Approach
// class Solution { 
//     public int countPairs(List<Integer> nums, int target) { 
//         int n=nums.size(); 
//         int count=0; 
//         for(int i=0;i<=n-2;i++)
//         {
//              for(int j=i+1;j<n;j++){ 
//                 if(nums.get(i)+nums.get(j) < target){ 
//                     count++; 
//                     }

//                      } 

//                      } 
//                      return count; 
//                      }

//                      }

class Solution {
    public int countPairs(List<Integer> nums, int target) {

        Collections.sort(nums);

        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right) {

            if (nums.get(left) + nums.get(right) < target) {
                count+=(right-left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}