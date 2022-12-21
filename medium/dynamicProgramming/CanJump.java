class Solution {
    public boolean canJump(int[] nums) {
        int currentIndex = 0;
        for(int i = 0;i<= currentIndex && i < nums.length;i++){
            currentIndex = Math.max(currentIndex,nums[i] + i);
        }
        return currentIndex >= nums.length - 1;
    }
}