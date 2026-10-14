class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int left = 0;
        int maxLen = 1;

        for (int right = 1; right < n; right++) {
            int prev = Integer.compare(arr[right - 1], arr[right]);

            if (prev == 0) {
                left = right;
            } else if (right == 1 ||
                    Integer.compare(arr[right - 2], arr[right - 1]) == prev) {
                left = right - 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}