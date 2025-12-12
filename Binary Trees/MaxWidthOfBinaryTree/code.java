// ✅ Time Complexity Explanation

// Best Case — O(N)
// Even in the best case (skewed or balanced), the BFS must still visit every node once to compute widths → so O(N).

// Average Case — O(N)
// For a typical/random binary tree, level-order traversal still touches all nodes → so O(N).

// Worst Case — O(N)
// Even for the worst case (very wide tree or very deep tree), BFS still processes every node once → so O(N).

// 👉 Conclusion:
// TC is always O(N) because BFS must visit all nodes to compute widths.

// ✅ Space Complexity Explanation

// Best Case — O(1)
// If the tree is skewed, each level has only 1 node, so the BFS queue never holds more than 1 → O(1).

// Average Case — O(N)
// Most random trees have some level that contains a large number of nodes, often proportional to the total nodes → queue grows → O(N).

// Worst Case — O(N)
// In a perfectly balanced tree, the last level holds N/2 nodes, and BFS must store them in the queue → O(N).

// 👉 Conclusion:
// Space depends on maximum width of the tree, which ranges from 1 to N, so SC = O(width) → O(1) to O(N).



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
 class Pair{
    TreeNode node;
    long idx;
   Pair(TreeNode node, long idx){
    this.node=node;
    this.idx=idx;
   }

 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       Queue<Pair> q=new LinkedList<>();
       int maxWidth=0;
       if(root==null) return 0;
       q.add(new Pair(root,0));
       while(!q.isEmpty()){
  
      long startIdx = q.peek().idx;
      long endIdx= startIdx;
      int n=q.size();
      for(int i=0;i<n;i++){
      Pair p=q.remove();
      TreeNode node=p.node;
      endIdx=p.idx;
        if(node.left!=null) q.add(new Pair(node.left, 2*p.idx+1));
        if(node.right!=null) q.add(new Pair (node.right, 2*p.idx+2));
      }

      maxWidth=Math.max(maxWidth,  (int)(endIdx-startIdx+1));
       } 
       return maxWidth;
    }
}