class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if(digit != '.'){
                    if(
                        !seen.add(digit + " at col" + i) ||
                    !seen.add(digit + " at row" + j) ||
                    !seen.add(digit + " in box: " + i/3 + "-" + j/3)
                    )
                    {
                        return false;
                    }
                    
                }
            }
        }
        return true;
    }
}
