class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] mat = new int[row][col];
        int maxlen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxlen = Math.max(maxlen, dfs(matrix, i, j, mat));
            }
        }
        return maxlen;

    }

    private int dfs(int[][] matrix, int r, int c, int[][] mat) {
        if (mat[r][c] != 0)
            return mat[r][c];

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int max = 1;

        for (int[] dir : dirs) {
            int newRow = r + dir[0], newCol = c + dir[1];
            if (newRow >= 0 && newRow < matrix.length &&
                    newCol >= 0 && newCol < matrix[0].length &&
                    matrix[newRow][newCol] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(matrix, newRow, newCol, mat));
            }
        }

        mat[r][c] = max;
        return max;
    }

}
