class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i = 0;i<= maxIndex && i < nums.length;i++){
            maxIndex = Math.max(maxIndex,nums[i] + i);
        }
        return maxIndex >= nums.length - 1;
    }
}