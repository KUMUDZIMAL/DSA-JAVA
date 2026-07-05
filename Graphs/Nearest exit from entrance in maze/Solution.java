import java.util.*;
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                if ((r == 0 || r == m - 1 || c == 0 || c == n - 1) &&
                    !(r == entrance[0] && c == entrance[1])) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        maze[nr][nc] == '.' &&
                        !visited[nr][nc]) {

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}