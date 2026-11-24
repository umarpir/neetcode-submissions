class Solution {
    public int characterReplacement(String s, int k) {
        int pointerA = 0;
        HashMap<Character, Integer> count = new HashMap();

        int maxFreq = 0;

        int largestWindow = 0;

        for(int pointerB = 0; pointerB < s.length(); pointerB++) {

            count.put( s.charAt(pointerB), count.getOrDefault( s.charAt(pointerB), 0  ) + 1 );
            maxFreq = Math.max(maxFreq,  count.get(s.charAt(pointerB)));

            while(((pointerB - pointerA + 1) - maxFreq) > k)
            {
                 count.put(s.charAt(pointerA), count.get(s.charAt(pointerA)) - 1 );
                 pointerA++;
            }

            largestWindow = Math.max(largestWindow, (pointerB - pointerA + 1));

        }

        return largestWindow;

    }
}


//characters_to_replace = window_size - max_count