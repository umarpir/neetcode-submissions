class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        for(int i = 0; i < nums.length - 2;i ++) {
            if(nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            int target = -nums[i];
            while(left<right) {
                int currentSum = nums[left] + nums[right];
                if(currentSum < target){
                    left++;
                } else if (currentSum > target) {
                    right --;
                } else {
                    results.add(List.of(nums[i], nums[left], nums[right]));
                    int lv = nums[left];
                    int rv = nums[right];

                    while(left<right && nums[left] == lv){left++;}
                    while(left<right && nums[right] == rv){right--;}
                }

            }
        }
        return results;

    }
}