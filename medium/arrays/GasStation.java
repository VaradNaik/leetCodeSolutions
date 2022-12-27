class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank=0,curr_tank=0;
        int answer =0;
        for(int i =0;i<gas.length;i++){
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if(curr_tank < 0){
                curr_tank = 0;
                answer = i + 1;
            }
        }
        return total_tank < 0 ? -1 : answer;
    }
}