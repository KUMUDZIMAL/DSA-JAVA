class TreeAncestor {

    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {

        LOG = 17;

        up = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {

                int ancestor = up[i][j - 1];

                if (ancestor == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[ancestor][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        for (int j = 0; j < LOG; j++) {

            if (((k >> j) & 1) == 1) {

                node = up[node][j];

                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
}
