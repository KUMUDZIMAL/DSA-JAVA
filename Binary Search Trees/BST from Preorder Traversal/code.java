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
    public TreeNode bstFromPreorder(int[] preorder) {
    int[] i=new int[1];
    i[0]=0;
    long bound = Integer.MAX_VALUE;
    return X(preorder,i,bound);

    }

    public TreeNode X(int[] preorder, int[] i, long bound){
if(i[0]==preorder.length || preorder[i[0]]>bound){
    return null;
}
TreeNode root = new TreeNode(preorder[i[0]++]);
root.left= X(preorder,i, root.val);
root.right=X(preorder,i, bound);
return root;
    }
}