class Solution {
    private static final int LAND = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
       int length = grid.length;
       int width = grid[0].length;

       for(int i = 0 ; i < length; i++){

                for(int j = 0; j < width; j++){

                if(grid[i][j] == 0){
                    q.offer(new int[]{ i, j });
                }
                
            }

       }

       int[][] directions = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
       };


       if(q.size() == 0) return;

       while(!q.isEmpty()){
        // now will have the current value, either 0 for treasure or a distance
        int[] val = q.poll();
        int row = val[0];
        int col = val[1];
        
        for(int[] direction: directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow < 0 || newCol < 0 || newRow >= length || newCol >= width || 
                grid[newRow][newCol] != LAND){
                    continue;
                }
            
            grid[newRow][newCol] = grid[row][col] + 1;
            q.add(new int[]{newRow, newCol});

        }


       }


    }

}
