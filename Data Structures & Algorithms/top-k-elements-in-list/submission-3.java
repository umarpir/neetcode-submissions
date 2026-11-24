class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // create a freq map and bucket to store the vals
       Map<Integer, Integer> map = new HashMap();
       List<Integer>[] bucket = new List[nums.length + 1];
    //    1 4
    //    2 4
    //    5 1

        // map of the frequencies
        // init the lists inside the buckets
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        //add the frequencies and vals to map
       for(int num: nums){
        map.put(num, map.getOrDefault(num, 0) + 1);
       }


        // loop through the map and add to list using freq as index
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int frequency = entry.getValue();

            bucket[frequency].add(number);
        }




        // ensure you loop backwards
        // result list should be of length k as we dont need more
        // also have an index against k as we dont want more than k vals
        int res[] = new int[k];
        int kIndex = 0;

        for(int i = bucket.length -1; i > 0 && kIndex <= k; i--){
            for(int n : bucket[i]){
                res[kIndex] = n;
                kIndex++;
                if(kIndex == k){
                    return res;
                }
            }
        }

        return res;
    }
}
