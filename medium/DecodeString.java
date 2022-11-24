class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> kStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }
            else if(ch == '['){
                kStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k=0;
            }
            else if(ch == ']'){
                StringBuilder decded = stringStack.pop();

                for(int j = kStack.pop();j>0;j--){
                    decoded =
                }
            }
        }
    }
}