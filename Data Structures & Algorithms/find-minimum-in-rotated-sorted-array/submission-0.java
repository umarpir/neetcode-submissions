class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right)
        {
            int mid  = left + (right - left) / 2;
            
            if(nums[mid] > nums[right])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }

        return nums[right];
    }
}
//[5,6,7,8,9,1,2,3,4]
