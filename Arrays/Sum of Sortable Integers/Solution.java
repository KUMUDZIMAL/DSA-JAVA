import java.util.*;
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n && valid; start += k) {
                int drops = 0;

                for (int j = 1; j < k; j++) {
                    if (nums[start + j - 1] > nums[start + j]) {
                        drops++;
                    }
                }

                if (drops > 1) {
                    valid = false;
                    break;
                }

                if (drops == 1) {
                    int first = nums[start];
                    int last = nums[start + k - 1];

                    if (first < last) {
                        valid = false;
                    }
                }

                int[] block = Arrays.copyOfRange(nums, start, start + k);
                Arrays.sort(block);

                for (int j = 0; j < k; j++) {
                    if (block[j] != sorted[start + j]) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) ans += k;
        }

        return ans;
    }
}