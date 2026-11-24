class Solution {

    List<String> result = new ArrayList<>();
    String digits;
    String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl",
    "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if(digits.isEmpty()) return result;
        backtrack(0, new StringBuilder());
        System.out.println();
        return result;
    }

    public void backtrack(int index, StringBuilder current){
        if(index >= digits.length()){
            result.add(current.toString());
            return;
        }

        String group = digitToChar[Character.getNumericValue(digits.charAt(index))];

        for(int i = 0; i < group.length(); i++){
            char c = group.charAt(i);
            current.append(c);

            backtrack(index + 1, current);

            current.deleteCharAt(current.length() - 1);

        }

    }
}
