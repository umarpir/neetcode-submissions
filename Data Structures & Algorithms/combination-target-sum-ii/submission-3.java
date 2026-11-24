class Solution {
    List<List<Integer>> result = new ArrayList();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        this.candidates = candidates;
        this.target = target;

        List<Integer> current = new ArrayList();

        backtrack(0, 0, current);

        return result;
    }

    private void backtrack(int index, int sum, List<Integer> current){

        //acceptance case and exit
        if(sum == target){
            result.add(new ArrayList(current));
            return;
        }

        // fail case and exit
        if(index == candidates.length || sum > target){
            return;
        }
        // 1 2 2 4 5 6 9
        
        int currentInt = candidates[index];

        
        int newSum = sum + currentInt;
        current.add(currentInt);
        backtrack(index + 1, newSum, current);
        current.removeLast();

        while(index < candidates.length - 1 && candidates[index + 1] == currentInt){
            index++;
        }


        backtrack(index + 1, sum, current);

    }
}
