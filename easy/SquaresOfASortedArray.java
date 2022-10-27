class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] answer = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                answer[index] = nums[right] * nums[right];
                index--;
                right--;
            } else {
                answer[index] = nums[left] * nums[left];
                index--;
                left++;
            }
        }
        return answer;
    }
}