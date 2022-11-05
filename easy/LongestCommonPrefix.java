class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        for(int i = 0;i<strs[0].length();i++){
            char current = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(i >= strs[j].length()){
                    return result;
                }
                if(i < strs[j].length() && strs[j].charAt(i) != current){
                    return result;
                }
            }
            result = result.concat(String.valueOf(current));
        }
        return result;
    }
}