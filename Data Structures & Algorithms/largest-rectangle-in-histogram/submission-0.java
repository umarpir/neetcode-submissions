class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int length = heights.length;
        int[] nse = new int[length];
        int[] pse = new int[length];

        Arrays.fill(nse, length);
        Arrays.fill(pse, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < length; i++)
        {
            int height = heights[i];
            while(!stack.isEmpty() &&
                 height < heights[stack.peek()])
            {
                int index = stack.pop();
                nse[index] = i;
            }
            stack.push(i);
        }

        for(int i = length - 1; i >= 0; i--)
        {
            int height = heights[i];
            while(!stack.isEmpty() && height < heights[stack.peek()])
            {
                int index = stack.pop();
                pse[index] = i;
            }
            stack.push(i);
        }

        int maxArea = 0;

        for(int i = 0; i < length; i++)
        {
            int width = (nse[i] - 1) - (pse[i] + 1) + 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}



