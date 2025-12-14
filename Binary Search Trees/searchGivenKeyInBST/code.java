// Time Complexity (TC)
// O(h)
// Har step me sirf ek subtree me jaate ho (left ya right)
// h = height of BST
// | Tree type    | Height (h) | Time         |
// | ------------ | ---------- | ------------ |
// | Balanced BST | log₂ n     | **O(log n)** |
// | Skewed BST   | n          | **O(n)**     |

// Space Complexity (SC): O(1)



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
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.val!=val){
            root=val<root.val?root.left:root.right;
        }
        return root;
    }
}