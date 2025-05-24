package cn.edu.tsinghua.leetcode.hot;

import java.util.LinkedList;
import java.util.Queue;

public class leet200 {

    /**
     * 岛屿数量
     *
     *
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     */


    /**
     * 方法一：dfs
     * <p>
     * 遍历每个节点
     * 使用深搜遍历一个岛屿中的 1，将其换成 0
     * <p>
     * <p>
     * O(MN)
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return num_islands;
    }

    public void dfs(char[][] grid, int r, int c) {
        int nc = grid[0].length;
        int nr = grid.length;
        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        // 递归上下左右
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 方法二： bfs
     * <p>
     * 想法：
     * 一次遍历每一个点，对于岛屿本身是连通的，使用（bfs\dfs）将当前岛屿的1全部置为0，这样下次就不会再遍历到这个岛屿了。
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * nc + j);
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        int x = cur / nc;
                        int y = cur % nc;
                        // 向四个方向走
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.offer((x - 1) * nc + y);
                            grid[x - 1][y] = '0';
                        }
                        if (x + 1 < nr && grid[x + 1][y] == '1') {
                            queue.offer((x + 1) * nc + y);
                            grid[x + 1][y] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.offer(x * nc + y - 1);
                            grid[x][y - 1] = '0';
                        }
                        if (y + 1 < nc && grid[x][y + 1] == '1') {
                            queue.offer(x * nc + y + 1);
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}
