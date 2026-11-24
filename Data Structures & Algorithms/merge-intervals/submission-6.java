class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        if(intervals.length == 1){
            return intervals;
        }

        // [1,3]

        List<int[]> res = new ArrayList();

        int[] current = intervals[0];
        res.add(current);

        for(int i = 0; i < intervals.length; i++){
            int[] interval = intervals[i];

            if(current[1] >= interval[0]){
                current[1] = Math.max(current[1], interval[1]);
            } else{
                current = interval;
                res.add(current);
            }
        }

        return res.toArray(new int[res.size()][]);

    }
}
