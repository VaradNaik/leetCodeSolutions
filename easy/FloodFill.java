class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevColor = image[sr][sc];
        if(prevColor != color){
            fill(image, sr,sc,color,prevColor);
        }
        return image;
    }
    void fill(int[][] image, int row, int col,int color,int prevColor){
        if(image[row][col]==prevColor){
            image[row][col] = color;
            if(row>0){
                fill(image,row-1,col,color,prevColor);
            }
            if(row < image.length-1){
                fill(image, row+1,col,color,prevColor);
            }
            if(col>0){
                fill(image,row,col-1,color,prevColor);
            }
            if(col<image[0].length - 1){
                fill(image,row,col+1,color,prevColor);
            }
        }
    }
}