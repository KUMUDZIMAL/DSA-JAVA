/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
     int ans=-1;
       int count=0;
    public int kthLargest(Node root, int k) {
        if(root==null) return -1;
      
   int ans = reverseinorder(root,k);
return ans;
        
    }
    public int reverseinorder(Node root,int k){
           if(root==null) return -1;
         
           reverseinorder(root.right,k);


    count++;
    if(count==k){
     ans=root.data;
       return ans;
    }
 
          reverseinorder(root.left,k);
          return ans;
           }
     
    
    

}