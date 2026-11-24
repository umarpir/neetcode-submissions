class Solution {

    char[][] grid;
    int count;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                char place = grid[i][j];
                if(place != '0'){
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
        
    }

    void dfs(int iIndex, int jIndex){
        if( iIndex < 0 || iIndex > grid.length - 1 || 
            jIndex < 0 || jIndex > grid[0].length - 1 ||
            grid[iIndex][jIndex] == '0'){
            return;
        }

        grid[iIndex][jIndex] = '0';

        dfs(iIndex + 1, jIndex);
        dfs(iIndex - 1, jIndex);

        dfs(iIndex, jIndex + 1);
        dfs(iIndex, jIndex - 1);
    }
}
