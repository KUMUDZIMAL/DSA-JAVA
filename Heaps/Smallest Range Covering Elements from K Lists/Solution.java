import java.util.*;
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new int[]{value, i, 0});
            max = Math.max(max, value);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (minHeap.size() == nums.size()) {

            int[] curr = minHeap.poll();

            int value = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (max - value < end - start ||
                (max - value == end - start && value < start)) {
                start = value;
                end = max;
            }

            if (col + 1 < nums.get(row).size()) {

                int next = nums.get(row).get(col + 1);

                minHeap.offer(new int[]{next, row, col + 1});

                max = Math.max(max, next);
            }
        }

        return new int[]{start, end};
    }
}