import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // value
            pairs[i][1] = i;       // original index
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];

            if (sum == target) {
                return new int[] { pairs[left][1], pairs[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }
}
    // Brute Force Approach

    //  int n = nums.length;
    //   for(int i=0;i<n-1;i++){
    //     for(int j=i+1;j<n;j++){
    //         if(nums[i]+nums[j]==target){
    //             return new int[]{i,j};
    //         }
    //         else{
    //             continue;
    //         }
    //     }
    //   }
    //   return new int[]{};
    // }
    // }
