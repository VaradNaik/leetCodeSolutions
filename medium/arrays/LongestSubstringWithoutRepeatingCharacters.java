public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        Map<Character,Integer> countMap = new HashMap();
        int result =0;
        while(right < s.length()){
            char rightChar = s.charAt(right);
            countMap.put(rightChar,countMap.getOrDefault(rightChar,0) + 1);
            while(countMap.get(rightChar) == 2){
                char leftChar = s.charAt(left);
                countMap.put(leftChar,countMap.get(leftChar) - 1);
                left++;
            }
            result = Math.max(result,right - left + 1);
            right++;
        }
        return result;
    }
}
