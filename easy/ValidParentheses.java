class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> charMap = new HashMap();
        Stack<Character> charStack = new Stack();

        charMap.put('}','{');
        charMap.put(')','(');
        charMap.put(']','[');

        for(int i = 0;i < s.length() ;i++){

            Character currentChar = s.charAt(i);

            if(!charStack.isEmpty() && charMap.containsKey(currentChar)){
                char topChar = charStack.pop();
                if(topChar != charMap.get(currentChar)){
                    return false;
                }
                continue;
            }

            charStack.push(currentChar);
        }

        return charStack.isEmpty();
    }
}