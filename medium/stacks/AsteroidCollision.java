class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> myStack = new Stack<>();

        for(int ast:asteroids){
            boolean flag = true;
            while(!myStack.isEmpty() && ast< 0 && myStack.peek() > 0){

                if(myStack.peek() < -ast){
                    myStack.pop();
                    continue;
                }
                else if(myStack.peek() == -ast){
                    myStack.pop();
                }
                flag = false;
                break;
            }
            if(flag){
                myStack.push(ast);
            }
        }

        return myStack.stream().mapToInt(i->i).toArray();
    }
}