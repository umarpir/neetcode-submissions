class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> ints = new HashSet<>();
        for (int number: nums) {
            if (ints.contains(number)) {
                return true;
            }
            ints.add(number);
        }
        return false;
    }
}
