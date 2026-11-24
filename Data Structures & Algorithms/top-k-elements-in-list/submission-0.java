class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> frequency = new HashMap<>();

        for(int num : nums) {
            frequency.put(num,frequency.getOrDefault(num,0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry : frequency.entrySet()) {
            int number = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(number);
        }
        int[] result = new int[k];

        int index = 0;
        for(int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for(int value : buckets[i]) {
                result[index] = value;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
