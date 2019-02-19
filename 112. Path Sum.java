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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum, 0);
    }
    
    public boolean helper(TreeNode node, int sum, int currSum){
        if(node == null) return false;
        currSum = currSum + node.val;
        if(currSum == sum && node.left == null && node.right == null) return true;
        return helper(node.left, sum, currSum) || helper(node.right, sum, currSum);
    }
    
}
