class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length() < s1.length())
        {return false;}

        HashMap<Character, Integer> s1Map = new HashMap();
        HashMap<Character, Integer> s2Map = new HashMap();

        int pointerA = 0;
        int pointerB = s1.length() - 1;

        //init the s1 hashmap
        for(int i = 0; i < s1.length(); i++)
        {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        //initialize s2 with length of s1
        for(int i = 0; i < s1.length(); i++)
        {
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(s1Map.equals(s2Map))
        {
            return true;
        }

        while(pointerB < s2.length() - 1){
            if(!s1Map.equals(s2Map))
            {
                s2Map.put(s2.charAt(pointerA), s2Map.get(s2.charAt(pointerA)) - 1);
                if (s2Map.get(s2.charAt(pointerA)) == 0)
                {
                    s2Map.remove(s2.charAt(pointerA));
                }
                pointerA++;
                pointerB++;
                s2Map.put(s2.charAt(pointerB), s2Map.getOrDefault(s2.charAt(pointerB), 0) + 1);
                if(s1Map.equals(s2Map))
                {
                    return true;
                }
            }
            else {
                return true;
            }

        }

        return false;

    }
}

