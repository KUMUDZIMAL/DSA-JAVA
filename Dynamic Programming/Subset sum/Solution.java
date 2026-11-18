class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: Target sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Base case: 0 elements se positive sum possible nahi
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                // Include current element
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i-1][j] ||
                               dp[i - 1][j - arr[i - 1]];
                }
                else{
                          // Exclude current element
                dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}