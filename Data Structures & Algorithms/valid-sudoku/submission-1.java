class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHasDigit = new boolean[9][9];
        boolean[][] colHasDigit = new boolean[9][9];
        boolean[][] boxHasDigit = new boolean[9][9];

        for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
            for(int colIndex = 0; colIndex < board[0].length; colIndex++){
                if(board[rowIndex][colIndex] == '.'){
                    continue;
                }

                int normalised = board[rowIndex][colIndex] - '1';

                int boxIndex = (rowIndex / 3) * 3 + (colIndex / 3);

                if(rowHasDigit[rowIndex][normalised] ||
                colHasDigit[colIndex][normalised] ||
                boxHasDigit[boxIndex][normalised]
                ){
                    return false;
                }

                rowHasDigit[rowIndex][normalised] = true;
                colHasDigit[colIndex][normalised] = true;
                boxHasDigit[boxIndex][normalised] = true;
            }
        }
        
        return true;
    }
}
