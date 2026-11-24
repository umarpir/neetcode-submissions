class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        //  1-2
        //    2--4
        //  1----4

        int count = 1;
        int prev = 0;

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= intervals[prev][1]){
                count++;
                prev = i;
            }
        }

        return intervals.length - count;
    }
}
