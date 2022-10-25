class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] sMap = new int[26];
        for(int i=0;i<s.length();i++){
            sMap[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
            int count = --sMap[t.charAt(i)-'a'];
            if(count < 0){
                return false;
            }
        }
        return true;
    }
}