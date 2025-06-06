class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;  // Calculate total sum of array
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;  // Pivot found
            }
            leftSum += nums[i];  // Move to next index
        }

        return -1;  // No pivot index found
    }
}
