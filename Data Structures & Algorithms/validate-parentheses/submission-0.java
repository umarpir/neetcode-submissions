class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> charStack = new Stack<>();
        HashMap<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for(char c : s.toCharArray()) {
            if(closeToOpen.containsKey(c)) {
                if(!charStack.isEmpty() && charStack.peek() == closeToOpen.get(c)) {
                    charStack.pop();
                } else {
                    return false;
                }
                
            } else {
                charStack.push(c);
            }
        }
        return charStack.isEmpty();
    }
}
