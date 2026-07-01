import java.util.*;
class Solution {

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !visited[nr][nc] &&
                heights[nr][nc] >= heights[row][col]) {

                dfs(heights, visited, nr, nc);
            }
        }
    }
}