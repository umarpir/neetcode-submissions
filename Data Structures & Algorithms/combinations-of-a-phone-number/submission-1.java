class Solution {

    List<String> result = new ArrayList<>();
    String digits;
    String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl",
    "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if(digits.isEmpty()) return result;
        backtrack(0,"");
        System.out.println();
        return result;
    }

    public void backtrack(int index, String current){
        if(index >= digits.length()){
            result.add(current);
            return;
        }

        String group = digitToChar[Character.getNumericValue(digits.charAt(index))];

        for(int i = 0; i < group.length(); i++){
            char c = group.charAt(i);
            current = current + c;

            backtrack(index + 1, current);

            current = current.substring(0, current.length() - 1);

        }

    }
}
