// Time Complexity: O(N)

// You visit each node exactly once, and each push/pop in the queue is O(1).
// Even the row.set() operations are O(1).
// So total = O(N).

// Space Complexity: O(N)

// Two things take space:

// 1. Queue space (BFS): O(N)
// In the worst case (last level of a complete tree), the queue holds ~N/2 nodes.

// 2. Result + row list: O(N)
// All values are stored in the output list.

// Total SC = O(N)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight= true;
        if(root==null) return result;
        q.add(root);
        while(!q.isEmpty()){
             int n=q.size();
            List<Integer> row = new ArrayList<>(Collections.nCopies(n,0));
           
          
            for(int i=0;i<n;i++){
       
                  TreeNode x = q.remove();
         int index= leftToRight? i: n-1-i;
         row.set(index, x.val);
         if(x.left!=null) q.add(x.left);
         if(x.right!=null) q.add(x.right);
            }
          leftToRight=!leftToRight;
          result.add(row);

        }
        return result;
    }
}