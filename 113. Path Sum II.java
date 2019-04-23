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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        pathSum(root, sum, root.val, first, result);
        return result;
    }
    
    public void pathSum(TreeNode node, int sum, int sumSoFar, List<Integer> candidate, List<List<Integer>> result){
        if(sumSoFar == sum && node.left == null && node.right == null){
            result.add(new ArrayList(candidate));
            return;
        }else{
            if(node.left != null){
                candidate.add(node.left.val);
                pathSum(node.left, sum, sumSoFar + node.left.val, candidate, result);
                candidate.remove(candidate.size()-1);
            }
            if(node.right != null){
                candidate.add(node.right.val);
                pathSum(node.right, sum, sumSoFar + node.right.val, candidate, result);
                candidate.remove(candidate.size()-1);
            }
        }
    }
}
