class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length -1;

        while (left < right) {
            int currentValue = numbers[left] + numbers[right];

            if(currentValue < target) {
                left++;
            }

            else if (currentValue > target) {
                right --;
            }
            else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[0];
    }
}
