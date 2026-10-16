import java.util.*;
class Solution {
    static final long MOD = 1_000_000_007L;
    long[] sum;
    long[] lazy;
    long[] squareSum;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, prev + 1, i, 1);

            ans = (ans + squareSum[1]) % MOD;
            last.put(nums[i], i);
        }

        return (int) ans;
    }

    void update(int node, int start, int end, int left, int right, long val) {
        if (left > end || right < start) return;

        if (left <= start && end <= right) {
            apply(node, start, end, val);
            return;
        }

        push(node, start, end);

        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, val);
        update(node * 2 + 1, mid + 1, end, left, right, val);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        squareSum[node] = (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
    }

    void apply(int node, int start, int end, long val) {
        long len = end - start + 1L;
        squareSum[node] = (squareSum[node] + 2 * val % MOD * sum[node] % MOD
                + val * val % MOD * len % MOD) % MOD;
        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) return;

        int mid = (start + end) / 2;
        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);
        lazy[node] = 0;
    }
}