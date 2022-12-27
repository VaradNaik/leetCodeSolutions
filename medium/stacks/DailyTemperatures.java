class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        Stack<Integer> indexStack = new Stack();
        int[] answer = new int[n];
        for(int i = 0 ; i < n ;i++){
            while(!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]){
                int indexOfTop = indexStack.pop();
                answer[indexOfTop] = i - indexOfTop;
            }
            indexStack.push(i);
        }
        return answer;
    }
}