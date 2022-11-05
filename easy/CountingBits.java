class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n+1];
        for(int i=0;i<=n;i++){
            answer[i] = numberOfOnes(i);
        }
        return answer;
    }
    private int numberOfOnes(int k){
        int result = 0;
        while(k!=0){
            result += k % 2;
            k=k/2;
        }
        return result;
    }
}