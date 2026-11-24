class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int result = 0;

        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right)
        {
            if(leftMax < rightMax)
            {
                left++;
                leftMax = Math.max(height[left], leftMax);
                result = result + (leftMax - height[left]);

            }
            else if(leftMax >= rightMax)
            {
                right--;
                rightMax = Math.max(height[right], rightMax);
                result = result + (rightMax - height[right]);
            }
        }
        return result;
    }
}
