class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList();
        backtrack(output, new StringBuilder(),0,0,n);
        return output;
    }
    void backtrack(List<String> output,StringBuilder sb, int open, int close, int max){

        if(sb.length() == 2*max){
            output.add(sb.toString());
            return;
        }
        if(open < max){
            sb.append("(");
            backtrack(output,sb,open+1,close,max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            backtrack(output,sb,open,close+1,max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}