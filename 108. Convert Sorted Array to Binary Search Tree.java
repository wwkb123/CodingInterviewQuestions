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
    public static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if(length == 0) return null;

        
        return sortedArrayToBST(nums, 0, length);
        
    }
    
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int length = (end - start);
        if(length <= 0 || nums.length == 0) return null;
        TreeNode node = new TreeNode(nums[length/2]);
        node.left = sortedArrayToBST(nums, 0, length/2);
        nums = Arrays.copyOfRange(nums, length/2 + 1, length);
        node.right = sortedArrayToBST(nums, length/2 + 1, length);
        return node;
    }
    
    
}
