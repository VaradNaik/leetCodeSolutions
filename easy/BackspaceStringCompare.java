class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildStringWithoutHash(s).equals(buildStringWithoutHash(t));
    }
    String buildStringWithoutHash(String t){
        StringBuilder bobTheBuilder = new StringBuilder();
        for(int i=0;i<t.length();i++){
            if(!bobTheBuilder.isEmpty() && t.charAt(i) == '#'){
                bobTheBuilder.deleteCharAt(bobTheBuilder.length()-1);
                continue;
            }
            if(t.charAt(i) != '#'){
                bobTheBuilder.append(t.substring(i,i+1));
            }

        }
        return bobTheBuilder.toString();
    }
}