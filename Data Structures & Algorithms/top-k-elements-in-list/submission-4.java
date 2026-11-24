class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a freq map and bucket to store the vals

        Map<Integer, Integer> freq = new HashMap();
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] results = new int[k];

        // init the lists inside the buckets
        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList();
        }

        //add the frequencies and vals to map
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // loop through the map and add to list using freq as index
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            int frequency = entry.getValue();
            int number = entry.getKey();

            bucket[frequency].add(number);
        }

        int kIndex = 0;
        for(int i = bucket.length - 1; i > 0 && kIndex < k; i--){
            for(int n : bucket[i]){
                results[kIndex] = n;
                kIndex++;
                if(kIndex == k){
                    return results;
                }
            }
        }

        return results;
    }
}
