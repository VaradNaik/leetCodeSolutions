class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if(pattern.length() != sArray.length){
            return false;
        }
        Map<Character,String> charMap = new HashMap();
        Map<String,Character> stringMap = new HashMap();

        for(int i = 0;i< pattern.length();i++){
            char currentChar = pattern.charAt(i);
            String currentString = sArray[i];

            if(!charMap.containsKey(currentChar)){
                if(stringMap.containsKey(currentString)){
                    return false;
                }
                charMap.put(currentChar,currentString);
                stringMap.put(currentString,currentChar);
            }
            else{
                if(!charMap.get(currentChar).equals(currentString)){
                    return false;
                }
            }
        }

        return true;
    }
}