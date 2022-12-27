class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : numSet) {
            if (!numSet.contains(num + 1)) {
                int currentMax = 1;
                int currentNum = num;

                while (numSet.contains(currentNum - 1)) {
                    currentMax += 1;
                    currentNum -= 1;
                }

                result = Math.max(result, currentMax);
            }
        }
        return result;
    }
}