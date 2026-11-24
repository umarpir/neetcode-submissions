class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;

        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(current, used);
        return result;
    }

    private void backtrack(List<Integer> current, boolean[] used){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(used[i]){
                continue;
            }

            current.add(nums[i]);
            used[i] = true;
            backtrack(current, used);

            current.removeLast();
            used[i] = false;

            // not needed as this will already go to the next as we are not using index - using a for loop
            // backtrack(current,used);
        }
    }
}
