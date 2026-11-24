class Solution {
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while(l < r) {

            while(l < r  && isNotValidChar(s.charAt(l))) {
                l++;
            }
            while(r > l  && isNotValidChar(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;

        
    }

    private boolean isNotValidChar(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
