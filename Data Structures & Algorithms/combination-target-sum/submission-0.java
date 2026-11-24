class Solution {
    List<List<Integer>> result = new ArrayList();
    int[] nums;
    int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int sum = 0;
        int index = 0;

        List<Integer> current = new ArrayList();
        backtrack(index, sum, current);

        return result;
    }

    public void backtrack(int index, int sum, List<Integer> current){
        if(sum == target){
            result.add(new ArrayList(current));
            return;
        }

        if(index == nums.length){
            return;
        }
        

        if(sum > target){
            return;
        }
        
        int currentInt = nums[index];

        current.add(currentInt);
        int currentSum = sum + currentInt;
        backtrack(index, currentSum, new ArrayList(current));

        current.removeLast();
        backtrack(index + 1, sum, new ArrayList(current));
        
    }
}
