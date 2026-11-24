class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap();

        for(String str: strs){
            int[] bucket = new int[26];

            for(char c: str.toCharArray()){
                bucket[c - 'a']++;
            }

            String key = Arrays.toString(bucket);

            results.putIfAbsent(key, new ArrayList<>());
            results.get(key).add(str);
        }

        return new ArrayList<>(results.values());
    }
}
