class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charMap = new int[26];

        for(char task: tasks){
            charMap[task - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int count: charMap){
            if(count > 0){
                heap.offer(count);
            }
        }

        int time = 0;

        Queue<int[]> q = new LinkedList<>();
        while(!heap.isEmpty() || !q.isEmpty()){
            time++; // we're onto next selection so we count this as a new cycle;

            if(heap.isEmpty()){
                // this is saying, if there is no more ready tasks to use as fillers then we must go to an existing tasks in queue
                // we just use this time because there is no more unique tasks to use, so we go to the earliest task (FIFO)
                time = q.peek()[1];
            } else {
                int count = heap.poll() - 1; // - 1 because we're using this, so we decrement it; no time added! we executed
                if(count > 0){ // check if this task is done 
                    q.add(new int[]{count, time + n}); // time + n is letting us know when the next time we can use this 
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                //we now know that this longest waiting queue item matches the time needed, so ready to execute
                //so we remove it from the queue, and add it to the heap - heap is items that can be used
                heap.add(q.poll()[0]);
            }
        }

        return time;
        
    }
}
