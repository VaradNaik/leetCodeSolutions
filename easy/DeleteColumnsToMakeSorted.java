class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int result = 0;
        for(int i = 0;i< n;i++){
            char prev = strs[0].charAt(i);
            for(int j=1;j<m;j++){
                if(Character.compare(prev,strs[j].charAt(i)) > 0){
                    result++;
                    break;
                }
                else{
                    prev = strs[j].charAt(i);
                }
            }
        }
        return result;
    }
}