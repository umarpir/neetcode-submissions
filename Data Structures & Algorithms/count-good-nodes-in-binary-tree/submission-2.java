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
    public int goodNodes(TreeNode root) {
        
        int res = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList();

        q.add(new Pair<>(root, Integer.MIN_VALUE));

        while(!q.isEmpty()){
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode current = pair.getKey();
            int currentValue = current.val;
            int maxValue = pair.getValue();

            if(current.val >= maxValue){
                res++;
            }

            if(current.left != null){
                q.add(new Pair<TreeNode, Integer>(current.left, Math.max(maxValue, currentValue)));
            }
            if(current.right != null){
                q.add(new Pair<TreeNode, Integer>(current.right, Math.max(maxValue, currentValue)));
            }

        }

        return res;
    }
}
