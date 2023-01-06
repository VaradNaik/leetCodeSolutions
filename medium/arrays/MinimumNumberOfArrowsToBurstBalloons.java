class Solution {
    public int findMinArrowShots(int[][] points) {

        /*
         example of why sorting by end works and not sorting by start
         -
         balloon 0 - 1 to 10
         balloon 1 - 2 to 4
         balloon 2 - 6 to 8

         if you sort by start, you get the answer as 1
         but actual answer is 2
        */
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
        int currentEnd = points[0][1];
        int result = 1;
        for(int i=1;i<points.length;i++){
            if(points[i][0] > currentEnd){
                currentEnd = points[i][1];
                result++;
            }
        }
        return result;
    }
}