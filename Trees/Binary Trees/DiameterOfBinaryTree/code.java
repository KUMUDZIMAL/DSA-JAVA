// ✅ Time Complexity Explanation

// Best Case — O(N)
// Even in the best case (perfectly balanced tree), the algorithm must visit every node once to compute heights and diameter → so O(N).

// Average Case — O(N)
// For a typical/random binary tree, the DFS still touches every node → so O(N).

// Worst Case — O(N)
// Even for the worst case (completely skewed tree), you still visit every node once → so O(N).

// 👉 Conclusion:
// TC is always O(N) because the algorithm does one DFS over all nodes.

// ✅ Space Complexity Explanation

// Best Case — O(log N)
// If the tree is height-balanced, the recursion depth = tree height = log N.

// Average Case — O(log N)
// Most practical binary trees are roughly balanced due to random insertions, so stack height ≈ log N.

// Worst Case — O(N)
// If the tree is skewed (like a linked list), the recursion goes N levels deep → O(N) space on the call stack.

// 👉 Conclusion:
// Space depends on tree height (H) → so SC = O(H), which ranges from logN to N.



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter= new int[1];
        height(root, diameter);
        return diameter[0];
    }
    public int height(TreeNode node, int[] diameter){
        if(node==null) return 0;
        int lh=0;
        int rh=0;
        lh=height(node.left,diameter);
        rh=height(node.right, diameter);
        diameter[0]= Math.max(diameter[0], lh+rh);
        return 1+Math.max(lh,rh);
    }
}