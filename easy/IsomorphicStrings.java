class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character,Character> tMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if(!map.containsKey(schar) && !tMap.containsKey(tchar)){
                map.put(schar,tchar);
                tMap.put(tchar,schar);
            }
            else{
                if(map.containsKey(schar) && map.get(schar) != tchar){
                    return false;
                }
                else if(tMap.containsKey(tchar) && tMap.get(tchar) != schar){
                    return false;
                }
            }
        }
        return true;
    }
}