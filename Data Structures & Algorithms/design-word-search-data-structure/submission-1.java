public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap();
    boolean endOfWord = false;
}


class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current  = root;

        for(char c : word.toCharArray()){
            current = current.children.computeIfAbsent(c, d -> new TrieNode());
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode current) {
        
        char[] wordArray = word.toCharArray();
        for(int i = index; i < word.length(); i++){
            
            if(wordArray[i] == '.'){
                for(TrieNode child : current.children.values()){
                    if(search(word, i + 1, child)){
                        return true;
                    }
                }

                return false;
            }

            TrieNode next = current.children.get(wordArray[i]);
            if(next == null){
                return false;
            }
            current = next;
        }
        return current.endOfWord;
    }

}
