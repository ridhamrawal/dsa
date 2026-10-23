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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // If both p and q are greater than root, LCA must be in the right subtree
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If both p and q are smaller than root, LCA must be in the left subtree
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // We have found the split point, which is the LCA
            else {
                return root;
            }
        }
        return null;
    }
}