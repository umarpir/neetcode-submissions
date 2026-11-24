class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            int length = str.length();
            sb.append(length).append('@').append(str);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        while(start < str.length()){
            while (str.charAt(end) != '@') {
                end++;
            }
            int length = Integer.parseInt(str.substring(start, end));
            start = end + 1;
            end = start + length;
            result.add(str.substring(start, end));
            start = end;
        }
        
        return result;
    }
}
