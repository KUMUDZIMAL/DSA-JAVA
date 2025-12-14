// Time Complexity
// Worst case: O(n)
// Sab nodes traverse ho sakte hain (jab k = n ya tree skewed ho)

//Space Complexity
// O(h) → recursion stack
// where h = height of BST


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
    int count = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        int ans = inorder(root, k);
        return ans;
    }

    private int inorder(TreeNode root, int k) {
        if (root == null) return -1;

        inorder(root.left, k);

        count++;
        if (count == k) {
            ans = root.val;
            return ans;
        }

        inorder(root.right, k);
        return ans;
    }
}