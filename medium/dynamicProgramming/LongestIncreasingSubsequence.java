class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j =i;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int num: dp) {
            result = Math.max(result, num);
        }

        return result;
    }
}