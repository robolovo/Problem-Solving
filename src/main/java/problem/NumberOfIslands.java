package problem;

import java.util.ArrayDeque;
import java.util.Deque;

/*
*   LeetCode - 200.Number of Islands (Medium)
*   https://leetcode.com/problems/number-of-islands/
*/
public class NumberOfIslands {

    static int row, col;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int count = 0;

    public static int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(grid, i, j) > 0) {
                    answer += 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                bfs(grid, i, j);
            }
        }

        return count;
    }

    private static int dfs(char[][] grid, int x, int y) {
        if (grid[x][y] == '0' || visited[x][y]) {
            return -1;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= row || ny >= col || visited[nx][ny]) {
                continue;
            }
            dfs(grid, nx, ny);
        }

        return 1;
    }

    private static void bfs(char[][] grid, int x, int y) {
        if (visited[x][y]) {
            return;
        }
        Deque<int[]> q = new ArrayDeque<>();

        visited[x][y] = true;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] position = q.pollFirst();
            int cx = position[0], cy = position[1];
            visited[cx][cy] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col || visited[nx][ny]) {
                    continue;
                }
                q.add(new int[]{nx, ny});
            }
        }

        count++;
    }

    public static void main(String[] args) {
        int i = numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
        System.out.println("i = " + i);
    }
}

