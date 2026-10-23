
// Time: O(n) (single pass)
//Space: O(1) (in-place)

public class Optimal {

        public int removeDuplicates(int[] nums) {
            int n = nums.length;
          
            int i = 0; // last unique index
            for (int j = 1; j < n; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1; // unique count
        }
    }
    
