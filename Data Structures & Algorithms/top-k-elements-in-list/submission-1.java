class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap();
       List<Integer>[] bucket = new List[nums.length + 1];
    //    1 4
    //    2 4
    //    5 1

        // map of the frequencies

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

       for(int num: nums){
        map.put(num, map.getOrDefault(num, 0) + 1);
       }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int frequency = entry.getValue();

            bucket[frequency].add(number);
        }


        int res[] = new int[k];
        int kIndex = 0;

        for(int i = bucket.length -1; i > 0 && kIndex < k; i--){
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
