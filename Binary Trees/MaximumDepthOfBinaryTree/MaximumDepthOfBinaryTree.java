// Level-Order Traversal

// Time Complexity: O(N)
// Space Complexity: 
// O(W) where W = maximum width of the tree
// Worst case: O(N) (if the tree is like a complete or full level with many nodes).
// Best case: O(1) (completely skewed like a linked list) 

// Recursive Traversal

//  Time Complexity : O(N)
//  Space Complexity : O(H) Where H = height of tree (because of recursion stack).
//  Best-case Space Complexity: O(log N) (balanced tree)
//  Worst-case Space Complexity: O(N) (skewed tree).


class Solution {
    public int maxDepth(TreeNode root) {
        // Recursive
        
        // if(root==null) return 0;
        // int lh=maxDepth(root.left);
        // int rh=maxDepth(root.right);
        // return 1 + Math.max(lh,rh);

        // Level order
        
        int ans=0;
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return 0;
        q.add(root);
    while(!q.isEmpty()){
ans++;
int n=q.size();
for(int i=0;i<n;i++){
    TreeNode x=q.remove();
    if(x.left!=null) q.add(x.left);
    if(x.right!=null) q.add(x.right);

}
        }
        return ans;
    }
}