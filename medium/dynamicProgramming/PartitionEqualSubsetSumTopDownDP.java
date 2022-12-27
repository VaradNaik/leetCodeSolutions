class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum =0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum %2 != 0){
            return false;
        }
        int subSetSum = totalSum/2,n=nums.length;
        Boolean[][] dp = new Boolean[n+1][subSetSum + 1];
        return dfs(nums,subSetSum,n,dp);

    }

    boolean dfs(int[] nums,int subSetSum, int n, Boolean[][] dp){
        if(subSetSum == 0){
            return true;
        }
        if(n == 0 || subSetSum<0){
            return false;
        }
        if(dp[n][subSetSum] != null){
            return dp[n][subSetSum];
        }
        boolean result = dfs(nums,subSetSum,n-1,dp) || dfs(nums,subSetSum - nums[n-1],n-1,dp);

        dp[n][subSetSum] = result;
        return result;

    }
}