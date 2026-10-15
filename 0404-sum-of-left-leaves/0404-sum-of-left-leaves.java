class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        
        // If the left child exists and is a leaf node, add its value
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        
        // Recursively check both left and right subtrees
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}