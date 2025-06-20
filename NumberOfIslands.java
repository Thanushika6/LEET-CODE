class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIslands++;  // One full island explored
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;

        grid[i][j] = '0';  // Mark cell as visited

        dfs(grid, i + 1, j);  // down
        dfs(grid, i - 1, j);  // up
        dfs(grid, i, j + 1);  // right
        dfs(grid, i, j - 1);  // left
    }
}
