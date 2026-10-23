import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }
    
    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        
        // Base case: if start > end, the subtree is null (empty tree)
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        
        // Iterate through all values from start to end to use as the root
        for (int i = start; i <= end; i++) {
            // Generate all left subtrees using values less than i
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            // Generate all right subtrees using values greater than i
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);
            
            // Combine each left and right subtree with the current root i
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode currRoot = new TreeNode(i);
                    currRoot.left = left;
                    currRoot.right = right;
                    allTrees.add(currRoot);
                }
            }
        }
        
        return allTrees;
    }
}