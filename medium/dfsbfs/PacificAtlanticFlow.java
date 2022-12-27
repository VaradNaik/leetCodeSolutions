class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length,n=heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,heights[i][0],heights,pacific);
            dfs(i,n-1,heights[i][n-1],heights,atlantic);
        }
        for(int j=0;j<n;j++){
            dfs(0,j,heights[0][j],heights,pacific);
            dfs(m-1,j,heights[m-1][j],heights,atlantic);
        }

        List<List<Integer>> result = new ArrayList();

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int prevheight,int[][] heights, boolean[][] visited){
        if(r<0 || r >= heights.length || c<0 || c>= heights[0].length || visited[r][c] || prevheight > heights[r][c]){
            return;
        }
        visited[r][c] = true;
        dfs(r+1,c,heights[r][c],heights,visited);
        dfs(r,c+1,heights[r][c],heights,visited);
        dfs(r-1,c,heights[r][c],heights,visited);
        dfs(r,c-1,heights[r][c],heights,visited);
    }
}