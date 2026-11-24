class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for(int num: nums){
            add(num);
        }
    }
    
    // make sure that the smallest value is always the kth largest e.g. 3rd largest, so always size of 3
    public int add(int val) {
        //add the value first
        minHeap.offer(val);
        // perform a check, and if the heap is larger than e.g. 3 = k then poll it to keep the size right 
        if(minHeap.size() > k){
            minHeap.poll();
        }
        // finally return the root value as that is the kth largerst
        return minHeap.peek();
    }
}
