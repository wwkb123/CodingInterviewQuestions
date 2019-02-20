/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int d1 = getDepth(root.left);
        int d2 = getDepth(root.right);
        
        return Math.abs(d1 - d2) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getDepth(TreeNode node){
        if(node == null) return 0;        
        return Math.max(getDepth(node.left),getDepth(node.right))+1;
    }
}
