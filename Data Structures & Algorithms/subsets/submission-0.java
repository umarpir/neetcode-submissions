class Solution {

    List<List<Integer>> res = new ArrayList();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> set = new ArrayList();
        backtrack(set, 0);
        return res;
    }


    private void backtrack(List<Integer> set, int index){
        
        if(index == nums.length){
            res.add(set);
            return;
        }

        // add the new integer to the set, and increment
        set.add(nums[index]);
        backtrack(new ArrayList(set), index + 1);

        //add nothing to the set and increment
        set.removeLast();
        backtrack(new ArrayList(set), index + 1);

    }


}
