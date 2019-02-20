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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        helper(root, "", result);
        return result;
    }
    
    public void helper(TreeNode node, String s, List<String> result){
        if(node == null) return;
        if(node.left == null && node.right == null){
            s = s + node.val;
            result.add(s);
        }
        s = s + node.val + "->";
        helper(node.left, s, result);
        helper(node.right, s, result);
    }
}
