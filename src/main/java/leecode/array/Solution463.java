package leecode.array;

import one.redBlackTree.Solution;

/**
 * @description: https://leetcode-cn.com/problems/island-perimeter/
 * 岛屿的周长
 * @author: xwy
 * @create: 18:54 2020/10/30
 **/

public class Solution463 {
    public int islandPerimeter(int[][] grid) {

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 如果是陆地 看他的上下左右是否为水 或者边界 是的话+1
                if (grid[i][j] == 1) {
                    // 上
                    if (i == 0) {
                        // 边界
                        sum++;
                    } else {
                        // 非边界
                        // 上面是否为水
                        if (grid[i - 1][j] == 0) {
                            sum++;
                        }
                    }
                    // 下
                    if (i == grid.length - 1) {
                        // 边界
                        sum++;
                    } else {
                        //非边界
                        // 下面是否为水
                        if (grid[i + 1][j] == 0) {
                            sum++;
                        }
                    }
                    // 左
                    if (j == 0) {
                        //边界
                        sum++;
                    } else {
                        // 非边界
                        // 左边是否为水
                        if (grid[i][j - 1] == 0) {
                            sum++;
                        }
                    }
                    // 右
                    if (j == grid[i].length - 1) {
                        // 边界
                        sum++;
                    } else {
                        // 非边界
                        // 右边是否为水
                        if (grid[i][j + 1] == 0) {
                            sum++;
                        }
                    }
                }
            }
        }

        return sum;
    }


    // x或 y 轴向 往 下右上左 移动
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        // tx < 0，已是左边界；tx >= n，已是右边界
                        // ty < 0，已是上边界；ty >= m，已是下边界
                        // grid[tx][ty] == 0，相邻格子是水域
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }


    // 深度优先搜索
    public int islandPerimeter2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution463 solution463 = new Solution463();
        int[][] grid = {{1}};
        System.out.println(solution463.islandPerimeter(grid));
    }
}