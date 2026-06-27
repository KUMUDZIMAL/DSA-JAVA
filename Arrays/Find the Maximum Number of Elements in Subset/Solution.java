import java.util.*;
class Solution {
    public int maximumLength(int[] nums) {
        int maxNum = 0;
        for (int x : nums) {
            maxNum = Math.max(maxNum, x);
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = count.containsKey(1)
                ? count.get(1) - (count.get(1) % 2 == 0 ? 1 : 0)
                : 1;

        for (int num : nums) {
            if (num == 1) {
                continue;
            }

            int length = 0;
            long x = num;

            while (x <= maxNum &&
                   count.containsKey((int) x) &&
                   count.get((int) x) >= 2) {
                length += 2;
                x *= x;
            }

            ans = Math.max(ans,
                    length + (x <= maxNum && count.containsKey((int) x) ? 1 : -1));
        }

        return ans;
    }
}