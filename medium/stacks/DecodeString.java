class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> kStack = new Stack<>();

        StringBuilder currentStringBuilder = new StringBuilder();
        int k =0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }
            else if(ch == '['){
                kStack.push(k);
                stringStack.push(currentStringBuilder);
                currentStringBuilder = new StringBuilder();
                k=0;
            }
            else if(ch == ']'){
                StringBuilder decoded = stringStack.pop();

                for(int j = kStack.pop();j>0;j--){
                    decoded.append(currentStringBuilder);
                }

                currentStringBuilder = decoded;
            }
            else{
                currentStringBuilder.append(ch);
            }
        }
        return currentStringBuilder.toString();
    }
}