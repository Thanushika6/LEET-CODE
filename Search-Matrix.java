class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int midvalue = matrix[row][col];
            if (midvalue == target) {
                return true;
            } else if (midvalue < target) {
                left = mid + 1;
            } else if (midvalue > target) {
                right = mid - 1;

            }
        }

        return false;
    }
}
