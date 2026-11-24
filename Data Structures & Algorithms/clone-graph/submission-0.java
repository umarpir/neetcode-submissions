/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    Node result = new Node();

    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        if(node.val == 1 && node.neighbors.size() == 0){
            return new Node(1, new ArrayList<Node>());
        }

        return bfs(node);
    }


    private Node bfs(Node root){

        Queue<Node> queue = new LinkedList<>();

        HashMap<Node, Node> seen = new HashMap<>();

        seen.put(root, new Node(root.val));
        queue.offer(root);

        while(!queue.isEmpty()){

            Node workingNode = queue.poll();
            Node clone = seen.get(workingNode);

                      
            for(Node neighbor : workingNode.neighbors){
                if(!seen.containsKey(neighbor)){
                    seen.put(neighbor, new Node(neighbor.val));
                    
                    queue.offer(neighbor);
                }

                clone.neighbors.add(seen.get(neighbor));
            }
        }

        return seen.get(root);
    }
}