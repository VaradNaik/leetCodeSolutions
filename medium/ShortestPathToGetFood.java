class Solution {
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    public int getFood(char[][] grid) {
        Queue<int[]> bfsq = new LinkedList<int[]>();
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '*'){
                    bfsq.add(new int[]{i,j});
                    break;
                }
            }
        }
        int steps = 0;
        while(!bfsq.isEmpty()){
            int size = bfsq.size();
            for(int i=0;i<size;i++){
                int[] cell = bfsq.poll();
                int currentX = cell[0];
                int currentY = cell[1];
                if(grid[currentX][currentY] == '#'){
                    return steps;
                }
                if(grid[currentX][currentY] == 'X'){
                    continue;
                }
                grid[currentX][currentY] = 'X';

                for(int[] dir:dirs){
                    int newX = currentX + dir[0];
                    int newY = currentY + dir[1];

                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                            grid[newX][newY] != 'X'){
                        bfsq.offer(new int[]{newX,newY});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}