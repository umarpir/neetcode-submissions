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
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        int start = 0;
        for(int i = 1; i < intervals.size(); i++){
            Interval one = intervals.get(start);
            Interval two = intervals.get(i);

            if(two.start < one.end){
                return false;
            }

            start = i;
        }

        return true;
    }
}
