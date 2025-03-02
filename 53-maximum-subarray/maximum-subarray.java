class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}