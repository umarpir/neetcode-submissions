class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(
                (b[0] - 0) * (b[0] - 0) + (b[1] - 0) * (b[1] - 0),
                (a[0] - 0) * (a[0] - 0) + (a[1] - 0) * (a[1] - 0)
                )
        );

        for(int [] point : points){
            maxHeap.offer(point);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];

        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }


        return res;
    }
}
