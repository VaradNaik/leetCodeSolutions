class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1,right = nums.length -1 ;
        int result = -1;

        while(left <=  right){
            int mid = left + (right - left)/2;

            int count = 0;
            for(int num:nums){
                if(num <= mid){
                    count++;
                }
            }
            if(count > mid){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }
}

/*
Alternate solution that does not meet the problem statement requirements
class Solution {
    public int findDuplicate(int[] nums) {
        while(nums[0] != nums[nums[0]]){
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }
        return nums[0];
    }
}
*/


