class Solution {
    public boolean isAnagram(String s, String t) {
       Map<Character, Integer> map1 = new HashMap();
       Map<Character, Integer> map2 = new HashMap();
       if(s.length() != t.length()){
        return false;
       }

       for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            map1.merge(sChar, 1 , Integer::sum);
            map2.merge(tChar, 1 , Integer::sum);
       }

       return map1.equals(map2);
    }
}
