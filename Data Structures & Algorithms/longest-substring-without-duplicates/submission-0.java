class Solution {
    public int lengthOfLongestSubstring(String s) {
        int pointerA = 0, pointerB = 0;
        HashSet<Character> set = new HashSet();
        int maxSize = 0;

        while(pointerB < s.length())
        {
            if(!set.contains(s.charAt(pointerB)))
            {
                set.add(s.charAt(pointerB));
                maxSize = Math.max(maxSize, set.size());
                pointerB++;
            } 
            else
            {
                set.remove(s.charAt(pointerA));
                pointerA++;
            }
        }
        return maxSize;
    }
}
