class Solution {
    public boolean isValidSudoku(char[][] board) {

        int N = 9;

        Set<Character>[] rows = new HashSet[N];
        Set<Character>[] cols = new HashSet[N];
        Set<Character>[] boxes = new HashSet[N];

        for(int i=0;i<N;i++){
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }

        for(int r = 0;r <9;r++){
            for(int c=0;c<9;c++){
                Character current = board[r][c];
                if(current.equals('.')){
                    continue;
                }
                if(rows[r].contains(current)){
                    return false;
                }
                rows[r].add(current);

                if(cols[c].contains(current)){
                    return false;
                }
                cols[c].add(current);

                int boxIndex = (r/3)* 3 + c/3;

                if(boxes[boxIndex].contains(current)){
                    return false;
                }
                boxes[boxIndex].add(current);
            }
        }
        return true;
    }
}