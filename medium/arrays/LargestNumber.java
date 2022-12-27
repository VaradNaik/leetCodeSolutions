class Solution {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] input = new String[n];
        for(int i = 0;i<n;i++){
            input[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(input, new SortStrings());

        if(input[0].equals("0")){
            return "0";
        }
        String result = "";
        for(String s : input){
            result += s;
        }
        return result;
    }

    class SortStrings implements Comparator<String>{
        public int compare(String a ,String b){
            String sum = a + b;
            String reverseSum = b + a;
            return reverseSum.compareTo(sum);
        }
    }
}