class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int prevToPrevHouse = 0;
        int prevHouse = nums[0];
        for(int i = 2;i<=n;i++){
            int current = Math.max(prevHouse,prevToPrevHouse + nums[i-1]);
            prevToPrevHouse = prevHouse;
            prevHouse=current;
        }
        return prevHouse;
    }
}
