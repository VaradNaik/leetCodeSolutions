class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n==1){
            return 1;
        }
        int result =2;
        for(int i =0;i<n;i++){
            Map<Double,Integer> countMap = new HashMap<>();
            for(int j= 0 ;j< n;j++){
                if(j!=i){
                    countMap.merge(Math.atan2(points[j][1] - points[i][1],
                            points[j][0] - points[i][0]),1,(a,b) -> a + b);
                }
            }
            result = Math.max(result, Collections.max(countMap.values()) + 1);
        }
        return result;
    }
}