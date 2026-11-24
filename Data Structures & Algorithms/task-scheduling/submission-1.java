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

        //[A - A - A - A - A - B]         2

        // A 4 

        Queue<int[]> q = new LinkedList<>();
        time = 0;

        while(!q.isEmpty() || !heap.isEmpty()){
            time++;

            if(heap.isEmpty()){
                time = q.peek()[1];
            } else {
                int count = heap.poll() - 1; // - 1 becuase we're using this , so we decrement
                if(count > 0){
                    q.offer(new int[]{count, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                heap.offer(q.poll()[0]);
            }
        }

        return time;
        
    }
}
