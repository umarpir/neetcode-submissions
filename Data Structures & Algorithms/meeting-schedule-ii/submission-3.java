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

        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++ ){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int startCounter = 0;
        int endCounter = 0;
        
        int roomCounter = 0;
        int maxRooms = 0;
        
        while(startCounter < intervals.size()){
            
            
            // if there is a start before there is an end then we need another room, and lets see if the next start 
            // also starts before the next meeting ends
            if(starts[startCounter] < ends[endCounter]){
                roomCounter++;
                startCounter++;
            } else {
                roomCounter--;
                endCounter++;
            }
            
            maxRooms = Math.max(maxRooms, roomCounter);
        }
        
        return maxRooms;
    }
}
