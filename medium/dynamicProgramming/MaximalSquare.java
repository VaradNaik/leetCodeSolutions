class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols + 1];
        int answer = 0, prev = 0;
        for(int i =1 ;i<=rows;i++){
            for(int j = 1; j<=cols;j++){
                int temp = dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j] = Math.min(Math.min(dp[j-1],prev),dp[j]) + 1;
                    answer = Math.max(answer,dp[j]);
                }
                else{
                    dp[j]=0;
                }
                prev = temp;
            }
        }
        return answer * answer;
    }
}