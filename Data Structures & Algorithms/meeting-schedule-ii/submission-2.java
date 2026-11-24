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

        int starts[] = new int[intervals.size()];
        int ends[] = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        // 0 5 15
        // 10 20 40

        Arrays.sort(starts);
        Arrays.sort(ends);

        int startCounter = 0;
        int endCounter = 0;
        int roomCount = 0;
        int maxRooms = 0;

        while(startCounter < intervals.size()){
            if(starts[startCounter] < ends[endCounter]){
                roomCount++;
                startCounter++;
            } else {
                roomCount--;
                endCounter++;
            }

            maxRooms = Math.max(maxRooms, roomCount);
        }
        return maxRooms;
    }
}
