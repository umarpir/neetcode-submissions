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
    int preorderIdx = 0;
    HashMap<Integer,Integer> inOrderMap = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length != inorder.length)
            return null;
        
        int length = preorder.length;

        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        return splitTree(preorder, 0, length - 1);
    }


    TreeNode splitTree(int[] preorder, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd)
            return null;


        TreeNode root = new TreeNode(preorder[preorderIdx]);
        preorderIdx++;



        //----inorder----
        int splitIndex = inOrderMap.get(root.val);
        //left tree
        int leftTreeStart = inorderStart;
        int leftTreeEnd = splitIndex - 1;
        //right start
        int rightTreeStart = splitIndex + 1;
        int rightTreeEnd = inorderEnd;

        root.left = splitTree(preorder, leftTreeStart, leftTreeEnd);
        root.right = splitTree(preorder, rightTreeStart, rightTreeEnd);

        return root;

    }
}
