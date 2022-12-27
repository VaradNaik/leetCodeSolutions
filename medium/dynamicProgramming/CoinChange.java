class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int currentCoinValue = coins[j];
                if(i>=currentCoinValue){
                    dp[i] = Math.min(dp[i - currentCoinValue] + 1,dp[i]);
                }
            }
        }
        return dp[amount]<max?dp[amount]:-1;
    }
}