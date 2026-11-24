class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> values = new HashMap<>();

       for(String s : strs){
        char[] stringArr = s.toCharArray();
        Arrays.sort(stringArr);
        String sorted = new String(stringArr);
        values.putIfAbsent(sorted, new ArrayList<String>());
        values.get(sorted).add(s);
       }

        return new ArrayList<>(values.values());
    }
}
