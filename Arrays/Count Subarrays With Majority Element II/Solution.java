class Solution {
    class BinaryIndexedTree {
        private int n;
        private int[] tree;

        BinaryIndexedTree(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        BinaryIndexedTree bit = new BinaryIndexedTree(2 * n + 1);

        int prefix = n + 1;
        bit.update(prefix, 1);

        long ans = 0;

        for (int x : nums) {
            if (x == target) {
                prefix++;
            } else {
                prefix--;
            }

            ans += bit.query(prefix - 1);
            bit.update(prefix, 1);
        }

        return ans;
    }
}