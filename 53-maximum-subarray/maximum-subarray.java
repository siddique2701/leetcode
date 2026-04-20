class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];  // ✅ nums[0] லயே start
        int maxSum = nums[0];      // ✅ nums[0] லயே start

        for (int i = 1; i < nums.length; i++) {  // ✅ i=1 லயே start
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}