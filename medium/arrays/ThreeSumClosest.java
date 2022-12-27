class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length && diff != 0;i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum < target){
                    left++;
                    continue;
                }
                else{
                    right--;
                }
            }
        }
        return target - diff;
    }
}