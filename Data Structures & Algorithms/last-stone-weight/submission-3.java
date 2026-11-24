class Solution {
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

    public int lastStoneWeight(int[] stones) {
        for(int stone: stones){
            heap.offer(stone);
        }

        while(heap.size() > 1){
           int x = heap.poll();
           int y = heap.poll();

           if(x == y){
            continue;
           }

           int newStone = x - y;
           heap.offer(newStone);
        }

        if(heap.size() < 1){
            return 0;
        }
        return heap.peek();
    }

}
