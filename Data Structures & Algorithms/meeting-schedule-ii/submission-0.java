/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */


class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Queue<Interval> minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.end, b.end)
        );

        intervals.sort((a,b) -> Integer.compare(a.start,b.start));

        for(Interval interval : intervals){
            Interval heap = minHeap.peek();
            if(heap != null && interval.start >= heap.end){
                minHeap.poll();
            }
            minHeap.offer(interval);
        }

        return minHeap.size();
    }
}
