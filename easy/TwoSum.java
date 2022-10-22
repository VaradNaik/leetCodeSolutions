class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap = new HashMap();
        int[] answer = new int[2];
        indexMap.put(nums[0],0);
        for(int i = 1;i<nums.length;i++){
            if(indexMap.containsKey(target - nums[i])){
                answer[0]=i;
                answer[1]=indexMap.get(target - nums[i]);
                return answer;
            }
            indexMap.put(nums[i],i);
        }
        return answer;
    }
}