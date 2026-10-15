import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                currLevel.add(node.val);
                
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(currLevel);
        }
        
        // Reverse the list to get bottom-up order
        Collections.reverse(ans);
        return ans;
    }
}