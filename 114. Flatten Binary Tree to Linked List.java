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
    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        if(root.left != null && root.right != null){
            flatten(root.left);
            flatten(root.right);
            TreeNode curr = root.left;
            while(curr.right != null){
                curr = curr.right;
            }
            curr.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(root.left == null){
            flatten(root.right);
        }
        if(root.right == null){
            flatten(root.left);
            root.right = root.left;
            root.left = null;
        }
    }
}
