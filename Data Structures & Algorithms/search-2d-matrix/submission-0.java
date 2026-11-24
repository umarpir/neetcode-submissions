class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int[] targetRow = null;

        for(int[] nums : matrix)
        {
            int largestNumber = nums[nums.length - 1];
            if(largestNumber >= target)
            {
                int left = 0, right = nums.length - 1;

                while(left <= right)
                {
                    int midpoint = left + (right - left) / 2;

                    if(target < nums[midpoint])
                    {
                        right = midpoint - 1;
                    }

                    else if(target > nums[midpoint])
                    {
                        left = midpoint + 1;
                    }
            
                    else if (nums[midpoint] == target)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
