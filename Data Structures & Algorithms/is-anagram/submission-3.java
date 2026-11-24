class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        
        Map<Character, Integer> sMap = new HashMap();
        Map<Character, Integer> tMap = new HashMap();

        for(int i = 0; i < s.length(); i++){
            char sValue = s.charAt(i);
            char tValue = t.charAt(i);

            sMap.put(sValue, sMap.getOrDefault(sValue, 0) + 1);
            tMap.put(tValue, tMap.getOrDefault(tValue, 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
