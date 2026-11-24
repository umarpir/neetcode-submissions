class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        List<Integer> current = new ArrayList();
        backtrack(current, 0);
        return result;
    }

    private void backtrack(List<Integer> current, int index){
        
        if(index == nums.length){
            result.add(new ArrayList(current));
            return;
        }

        current.add(nums[index]);
        backtrack(current, index + 1);

        current.removeLast();


        // skip over duplicates when NOT taking a number! so it doesnt take duplicates as well, otherwise no point
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }

        backtrack(current, index + 1);
        
    }
}
