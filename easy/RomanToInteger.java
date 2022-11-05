class Solution {
    public int romanToInt(String s) {

        Map<String, Integer> values = new HashMap<>();

        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);

        int i = 0;
        int result = 0;
        while(i < s.length()){
            String currentString = s.substring(i,i+1);
            int currentValue = values.get(currentString);
            int nextValue = 0;
            if(i+1 < s.length()){
                nextValue = values.get(s.substring(i+1,i+2));
            }
            if(currentValue < nextValue){
                result += nextValue - currentValue;
                i+=2;
            }
            else{
                result += currentValue;
                i+=1;
            }
        }
        return result;
    }
}