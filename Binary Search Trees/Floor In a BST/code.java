// Time Complexity (TC)

// O(h)
// Har step me sirf ek side jaate ho (left ya right)
// BST ka height = h
// | Tree type    | h      | TC       |
// | ------------ | ------ | -------- |
// | Balanced BST | log₂ n | O(log n) |
// | Skewed BST   | n      | O(n)     |

// Space Complexity

// O(1)
// Tumne iterative solution use kiya
// Koi recursion stack ya extra data structure nahi


/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int x) {
     
       int floor=-1;
       while(root!=null){
           if(root.data == x){
              floor=root.data;
              return floor; 
           }
           else if(x>root.data){
               floor=root.data;
               root=root.right;
           }
           else{
               root=root.left;
           }
           
       }
       return floor;
    }
}