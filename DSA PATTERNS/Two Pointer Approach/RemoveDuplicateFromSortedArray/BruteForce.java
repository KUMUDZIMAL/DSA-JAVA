// Time: O(n) (set insertion) + O(n) (copying) = O(n)
// Space: O(n) (extra set)

import java.util.*;
public class BruteForce {
    
        public int removeDuplicates(int[] nums) {
            // Using LinkedHashSet to maintain order
            Set<Integer> set = new LinkedHashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            
            int i = 0;
            for (int num : set) {
                nums[i++] = num;
            }
            
            return set.size();
        }
    }
    

