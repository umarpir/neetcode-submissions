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

//  1,2,4,6,null,null,null,5,null,null.      2,4,null,null,5,null,null

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        String rootString = traverse(root);
        String subRootString = traverse(subRoot);
        

        return rootString.contains(subRootString);
    }

    private String traverse(TreeNode node){
        if(node == null){
            return "null";
        }

        StringBuilder sb = new StringBuilder(",");

        sb.append(node.val);
        sb.append(traverse(node.left));
        sb.append(traverse(node.right));
        
        return sb.toString();
    }
}
