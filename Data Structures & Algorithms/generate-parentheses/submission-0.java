class Solution {

    List<String> result = new ArrayList<>();
    int n;
    char openChar = '(';
    char closedChar = ')';

    public List<String> generateParenthesis(int n) {
        this.n = n;
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, 0);
        return result;
    }

    public void backtrack(StringBuilder current, int open, int closed){
        if(current.length() == n * 2){
            result.add(new String(current.toString()));
            return;
        }

        if(open < n){
            backtrack(current.append(openChar), open + 1, closed);
            current.deleteCharAt(current.length() - 1);

        }

        if(open > closed){
            backtrack(current.append(closedChar), open, closed + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
