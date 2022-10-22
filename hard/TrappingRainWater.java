//brute force
class Solution {
    public int trap(int[] height) {
        int answer = 0;

        for(int i = 0 ;i < height.length;i++){
            int left_max = 0, right_max = 0;
            for(int j=i;j>=0;j--){
                left_max = Math.max(left_max,height[j]);
            }
            for(int j=i;j<height.length;j++){
                right_max = Math.max(right_max,height[j]);
            }
            answer += Math.min(left_max,right_max) - height[i];
            System.out.println("answer is "+ answer +
                    "left_max is " + left_max + "right_max is " + right_max);
        }
        return answer;
    }
}
