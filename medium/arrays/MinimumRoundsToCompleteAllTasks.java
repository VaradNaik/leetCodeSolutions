class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int result = 0;
        for(int task: tasks){
            countMap.put(task,countMap.getOrDefault(task,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue() == 1){
                return -1;
            }
            int count = entry.getValue();
            if(count == 2){
                result++;
                continue;
            }
            result += count/3;
            if(count%3!=0){
                result++;
            }
        }
        return result;
    }
}