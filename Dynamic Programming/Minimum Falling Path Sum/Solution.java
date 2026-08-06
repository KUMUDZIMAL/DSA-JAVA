class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[] prev = matrix[0].clone();

        for (int i = 1; i < n; i++) {

            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {

                int up = prev[j];

                int leftDiagonal = Integer.MAX_VALUE;
                if (j > 0) {
                    leftDiagonal = prev[j - 1];
                }

                int rightDiagonal = Integer.MAX_VALUE;
                if (j < n - 1) {
                    rightDiagonal = prev[j + 1];
                }

                curr[j] = matrix[i][j] +
                        Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }

            prev = curr;
        }

        int ans = Integer.MAX_VALUE;

        for (int x : prev) {
            ans = Math.min(ans, x);
        }

        return ans;
    }
}