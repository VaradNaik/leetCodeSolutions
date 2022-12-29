class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }

        int last = 1;
        int secondLast = 1;
        int current=1;
        for(int i=1;i<s.length();i++){
            current = 0;
            if(s.charAt(i) != '0'){
                current = last;
            }
            Integer value = Integer.parseInt(s.substring(i-1,i+1));
            if(value > 9 && value < 27){
                current += secondLast;
            }
            secondLast = last;
            last = current;
        }
        return current;
    }
}