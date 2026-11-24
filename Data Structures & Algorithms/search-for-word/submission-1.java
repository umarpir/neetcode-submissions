class Solution {
    String word;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                // Launch the search. If any path returns true, we are done!
                if (backtrack(0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int curIdx, int rowIdx, int colIdx){
        if(curIdx == word.length()){
            return true;
        }

        if(rowIdx >= board.length || rowIdx < 0 || 
        colIdx >= board[0].length || colIdx < 0){
            return false;
        }

        char targetChar = word.charAt(curIdx);
        char boardChar = board[rowIdx][colIdx];
        if(targetChar != boardChar){
            return false;
        }

        char originalChar = board[rowIdx][colIdx];
        board[rowIdx][colIdx] = '#';

        boolean paths = backtrack(curIdx + 1, rowIdx + 1, colIdx) ||
                        backtrack(curIdx + 1, rowIdx - 1, colIdx) ||
                        backtrack(curIdx + 1, rowIdx, colIdx + 1) ||
                        backtrack(curIdx + 1, rowIdx, colIdx - 1);

        board[rowIdx][colIdx] = originalChar;

        return paths;
    }
}
