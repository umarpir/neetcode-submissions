public class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap();
    boolean endOfWord;
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode(); 
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()){
            current = current.children.computeIfAbsent(c, d -> new TrieNode());
        }

        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for(char c : word.toCharArray()){
            current = current.children.get(c);
            if(current == null){
                return false;
            }
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char c : prefix.toCharArray()){
            current = current.children.get(c);
            if(current == null){
                return false;
            }
        }

        return true;
    }
}
