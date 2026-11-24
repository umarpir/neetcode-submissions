class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int rowLength = matrix[0].length - 1;
        final int rowAmount = matrix.length - 1; 

        int targetRow = -1;

        int top = 0;
        int bottom = rowAmount;

        while (top <= bottom)
        {
            int midpoint = top + (bottom - top) / 2;

            if (matrix[midpoint][0] < target && matrix[midpoint][rowLength] < target)
            {
                top = midpoint + 1;
            }
            else if (matrix[midpoint][0] > target)
            {
                bottom = midpoint - 1;
            }

            else if (matrix[midpoint][0] <= target && matrix[midpoint][rowLength] >= target)
            {
                targetRow = midpoint;
                break;
            }
        }


        System.out.println(targetRow);

        if (targetRow == -1)
        {
            return false;
        }

        int left = 0, right = rowLength;
        while (left <= right)
        {
            int midpoint = left + (right - left) / 2;

            int val = matrix[targetRow][midpoint];

            if (val < target)
            {
                left = midpoint + 1;
            }
            else if (val > target)
            {
                right = midpoint - 1;
            }

            else
            {
                return true;
            }
        }
        return false;
    }
}
