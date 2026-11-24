/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        int diameter = 0;

        Map<TreeNode, Integer> nodeMap = new HashMap();
        Stack<TreeNode> nodeStack = new Stack();

        nodeStack.push(root);

        while(!nodeStack.isEmpty()){
            TreeNode current = nodeStack.peek();
            
            // add all first to traverse
            if(current.left != null && !nodeMap.containsKey(current.left))
            {
                nodeStack.push(current.left);
            }
            else if(current.right != null && !nodeMap.containsKey(current.right)){
                nodeStack.push(current.right);
            }


            else {
                
                nodeStack.pop();

                int leftDepth = nodeMap.getOrDefault(current.left, 0);
                int rightDepth = nodeMap.getOrDefault(current.right, 0);

                int maxDepth = Math.max(leftDepth, rightDepth);

                nodeMap.put(current, maxDepth + 1);

                int currentDiameter = leftDepth + rightDepth;
                diameter = Math.max(diameter, currentDiameter);

            }

        }

        return diameter;

    }
}
