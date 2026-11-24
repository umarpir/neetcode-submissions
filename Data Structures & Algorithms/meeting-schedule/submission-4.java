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
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.size() <= 1){
            return true;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));

        Interval current = intervals.getFirst();

        for(int i = 1; i < intervals.size(); i++){
            Interval working = intervals.get(i);

            if(current.end > working.start){
                return false;
            } 
            current = working;
        }
        
        return true;
    }
}