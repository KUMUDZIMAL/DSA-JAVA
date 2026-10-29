
import java.util.*;

class Solution {

    int LOG;
    int[][] up;
    int[] depth, tin, tout, parent, subtreeSize;
    int[] prefixMask;
    int timer;
    Fenwick fenwick;
    char[] chars;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        chars = s.toCharArray();

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        subtreeSize = new int[n];
        prefixMask = new int[n];

        int[] stack = new int[n];
        int[] order = new int[n];
        int top = 0, count = 0;

        parent[0] = 0;
        prefixMask[0] = 1 << (chars[0] - 'a');
        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = timer++;
            order[count++] = u;
            subtreeSize[u] = 1;

            for (int v : adj[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                prefixMask[v] =
                        prefixMask[u] ^ (1 << (chars[v] - 'a'));

                stack[top++] = v;
            }
        }

        for (int i = count - 1; i > 0; i--) {
            int u = order[i];
            subtreeSize[parent[u]] += subtreeSize[u];
        }

        for (int i = 0; i < n; i++) {
            tout[i] = tin[i] + subtreeSize[i] - 1;
        }

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int v = 0; v < n; v++) {
                up[k][v] = up[k - 1][up[k - 1][v]];
            }
        }

        fenwick = new Fenwick(n);
        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');
                int delta = oldMask ^ newMask;

                if (delta != 0) {
                    fenwick.rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = findLCA(u, v);

                int maskU =
                        prefixMask[u] ^ fenwick.pointQuery(tin[u]);

                int maskV =
                        prefixMask[v] ^ fenwick.pointQuery(tin[v]);

                int pathMask = maskU ^ maskV
                        ^ (1 << (chars[lca] - 'a'));

                result.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return result;
    }

    private int findLCA(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }

    static class Fenwick {

        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        private void update(int index, int value) {
            index++;

            while (index <= n + 1) {
                bit[index] ^= value;
                index += index & -index;
            }
        }

        void rangeXor(int left, int right, int value) {
            update(left, value);
            update(right + 1, value);
        }

        int pointQuery(int index) {
            index++;
            int answer = 0;

            while (index > 0) {
                answer ^= bit[index];
                index -= index & -index;
            }

            return answer;
        }
    }
}
