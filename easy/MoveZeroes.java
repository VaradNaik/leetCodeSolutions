class Solution {
    public void moveZeroes(int[] nums) {
        int zeroesTillHere =0;
        int index = 0;
        while(index<nums.length){
            if(nums[index] ==0){
                zeroesTillHere++;
                index++;
                continue;
            }
            else{
                nums[index - zeroesTillHere] = nums[index];
                index++;
            }
        }
        for(int i = nums.length - 1;i>= nums.length - zeroesTillHere;i--){
            nums[i]=0;
        }
    }
}