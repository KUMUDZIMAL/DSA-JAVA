class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        long[] base = new long[size];

        for (int v = 0; v < m; v++) {
            base[v] = v;
            base[m + v] = m - 1 - v;
        }

        long[][] trans = new long[size][size];

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < y; x++) {
                trans[y][m + x] = 1;
            }
        }

        for (int y = 0; y < m; y++) {
            for (int x = y + 1; x < m; x++) {
                trans[m + y][x] = 1;
            }
        }

        long[][] power = matrixPower(trans, n - 2);
        long[] result = multiply(power, base);

        long ans = 0;
        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int n = mat.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, mat);
            }
            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                long val = a[i][k];

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    c[i][j] = (c[i][j] + val * b[k][j]) % MOD;
                }
            }
        }

        return c;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0 || vec[j] == 0) continue;

                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }
}