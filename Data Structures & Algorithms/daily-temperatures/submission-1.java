class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 1. result array
        int[] results = new int[temperatures.length]; 
        // 2. create a stack that contains temp and the index (we need the index of next)
        Stack<int[]> stack = new Stack<>(); 

// 3. Iterate forward as finding next bigger
        for(int i = 0; i < temperatures.length; i++){ 
            // set the working temperature
            int currentTemp = temperatures[i]; 
// 4. Check that its not empty and check if it is larger than the previous else push it on 
// because its not larger anyway 
            while(!stack.isEmpty() && currentTemp > stack.peek()[0]) { 
// 5. Because its bigger, we get index and the temp as this is the pair
// we found the next biggest value for
               int pair[] = stack.pop();
// 6. we get the index from the pair we want and then find the difference and the 
// using this current index and the pair index
                results[pair[1]] = i - pair[1];
            }
// we carry on pushing if its empty stack/ no bigger value
            stack.push(new int[]{currentTemp, i});
        }

        return results;
    }
}
