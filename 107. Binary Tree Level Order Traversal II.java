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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.size() > 0){
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                if(node != null){
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(list.size() > 0)result.add(0,list);
            list = new ArrayList();
        }
        
        return result;
        
    }
}
