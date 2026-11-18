class Solution {
    public int knapsack(int W, int val[], int wt[]) {

        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {

                int val1 = val[i-1];
                int wt1 = wt[i-1];

                if(wt1 <= j) {
                    dp[i][j] = Math.max(
                        val1 + dp[i-1][j-wt1],
                        dp[i-1][j]
                    );
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
}