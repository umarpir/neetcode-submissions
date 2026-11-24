class Solution {

    Queue<int[]> pacific = new LinkedList();
    Queue<int[]> atlantic = new LinkedList();

    int[][] heights;

    boolean[][] pacificSeen;
    boolean[][] atlanticSeen;

    List<List<Integer>> results = new ArrayList();



    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        int length = heights.length;
        int width = heights[0].length;


        pacificSeen = new boolean [length][width];
        atlanticSeen = new boolean [length][width];

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){

                if(i == 0 || j == 0){
                    pacific.offer(new int[]{i, j});
                    pacificSeen[i][j] = true;
                }
                if(i == heights.length - 1 || j == heights[0].length - 1){
                    atlantic.offer(new int[]{i, j});
                    atlanticSeen[i][j] = true;
                }
            }
        }

        bfs(pacific, pacificSeen);
        bfs(atlantic, atlanticSeen);

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){

                if(pacificSeen[i][j] && atlanticSeen[i][j]){
                    results.add(List.of(i,j));
                }
            }
        }

        return results;
    }

    private void bfs(Queue<int[]> queue, boolean[][] seen){

        int[][] directions = {
            {1,0},{-1,0},{0,1},{0,-1}
        };
        
        while(!queue.isEmpty()){
            int[] places = queue.poll();

            int i = places[0];
            int j = places[1];

            for(int[] direction: directions){
                int row = i + direction[0];
                int col = j + direction[1];

                if(row >= heights.length || col >= heights[0].length){
                    continue;
                }

                if(row < 0 || col < 0){
                    continue;
                }

                if(seen[row][col] || heights[row][col] < heights[i][j]){
                    continue;
                }

                queue.offer(new int[]{row,col});
                seen[row][col] = true;
            }
        }
    }
}
