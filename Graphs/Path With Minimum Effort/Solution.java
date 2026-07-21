import java.util.*;
class Solution {
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{0, 0, 0});
        effort[0][0] = 0;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int row = curr[0];
            int col = curr[1];
            int currEffort = curr[2];

            if (row == m - 1 && col == n - 1) {
                return currEffort;
            }

            if (currEffort > effort[row][col]) {
                continue;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {

                    int diff = Math.abs(heights[row][col] - heights[newRow][newCol]);
                    int newEffort = Math.max(currEffort, diff);

                    if (newEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newEffort;
                        pq.offer(new int[]{newRow, newCol, newEffort});
                    }
                }
            }
        }

        return 0;
    }
}