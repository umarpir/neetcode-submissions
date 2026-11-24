class Solution {
    List<List<String>> result = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<String> current, int startIndex){

        // if the starting point is at the end of the word we're done
        if(startIndex >= s.length()){
            result.add(new ArrayList<>(current));
        }
        
        // Keep startIndex fixed and move end forward to try
        // progressively longer substrings: "a", "aa", "aab"
        for(int end = startIndex; end < s.length(); end++){
            
            // we make the substring a and the end index +1 (end index 1 doesnt include)
            // the second letter
            String sub = s.substring(startIndex, end + 1);

            if(!isPalindrome(sub)){
                continue; // go to bigger length as this isnt a palindrome e.g. ab -> aba
            }

            // as this is a match we then process it
            current.add(sub);
            //explore these cases and fill them up e.g. a aa etc
            // we use end + 1 because the new starting point will be the second a
            // will end up being [a a b]
            backtrack(current, end + 1);

            // as we've completed these and its been added, we remove them and move on
            // to the next set of possible strings, this removes it from current stack as 
            // once backtrack() is done it will have added to res list
            current.removeLast();
        }
    }


    private boolean isPalindrome(String str){
        
        int left = 0;
        int right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
