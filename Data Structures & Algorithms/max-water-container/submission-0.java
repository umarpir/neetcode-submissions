class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;

        int result = 0;

        while(left < right) {
            int width = right - left;
            int area = Math.min(heights[left],heights[right]) * width;

            result = Math.max(result, area);

            if(heights[left] <= heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return result;
    }
}
