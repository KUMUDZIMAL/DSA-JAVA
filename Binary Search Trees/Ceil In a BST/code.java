// Time Complexity
// O(h)
// Balanced BST → O(log n)
// Skewed BST → O(n)

// Space Complexity (SC)
// O(1)



/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
          int ceil=-1;
       while(root!=null){
           if(root.data == x){
               ceil=root.data;
              return  ceil; 
           }
           else if(x<root.data){
               ceil=root.data;
               root=root.left;
           }
           else{
               root=root.right;
           }
           
       }
       return ceil;
    }
}