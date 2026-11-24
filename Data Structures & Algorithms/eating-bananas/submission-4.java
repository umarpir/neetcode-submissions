class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for (int pile : piles) end = Math.max(end, pile);
        int minEatingRate = end;
        
        while(start <= end)
        {
            int midpoint = start + (end - start) / 2;
            long hoursNeeded = 0;

            for(int pile : piles)
            {
                hoursNeeded += Math.ceilDiv(pile , midpoint);

            }

            if(hoursNeeded > h)
            {
                start = midpoint + 1;
            }
            else
            {
                minEatingRate = midpoint;
                end = midpoint - 1;
            }
        }

        return minEatingRate;
        
    }
}
