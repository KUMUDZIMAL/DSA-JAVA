
// Time Complexity: 
// O(n), as each node is visited once even in a balanced tree (all best, avg and worst case).
// Space Complexity:
// Best case: For a balanced tree, the height is O(log n), so the space complexity is O(log n) due to the recursion stack.
// Worst case: For a skewed tree, the height is O(n), so the space complexity is O(n) due to the recursion stack.


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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long min_value, long max_value){
        if(root==null) return true;
        if(root.val<=min_value || root.val>=max_value) return false;
        return isValid(root.left, min_value, root.val) && isValid(root.right, root.val, max_value);
    }

}