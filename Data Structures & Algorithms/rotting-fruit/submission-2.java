class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int minute = 0;
        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {1, 0}, {-1, 0},{0,1},{0,-1}
        };

        while(!rotten.isEmpty() && fresh > 0){
            int round = rotten.size();
            for(int i = 0; i < round; i++)
            {
                int[] current = rotten.poll();
                for(int[] direction : directions){
                    int row = current[0] +  direction[0];
                    int col = current[1] +  direction[1];

                    if(row < 0 || row >= grid.length ||
                    col < 0 || col >= grid[0].length ||
                    grid[row][col] != 1){
                        continue;
                    }
                    
                    grid[row][col] = 2;
                    fresh--;
                    rotten.add(new int[]{row, col});
                }
            }
            minute++;
        }
    if(fresh != 0) return -1;
    return minute;
    }
}
