class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<List<Integer>> diagonals = new ArrayList<>();

        for (int i = 0; i < m + n - 1; i++) {
            diagonals.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagonals.get(i + j).add(mat[i][j]);
            }
        }

        int[] result = new int[m * n];
        int idx = 0;

        for (int k = 0; k < diagonals.size(); k++) {
            List<Integer> diagonal = diagonals.get(k);
            if (k % 2 == 0) {
                Collections.reverse(diagonal);  // Reverse for even diagonals
            }
            for (int val : diagonal) {
                result[idx++] = val;
            }
        }

        return result;
    }
}
