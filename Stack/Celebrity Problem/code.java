import java.util.Stack;
class Solution {
    public int celebrity(int mat[][]) {
       int n= mat.length;
       Stack<Integer> s = new Stack<>();
       for(int i=0;i<n;i++){
           s.push(i);
       }
       while(s.size()>1){
          int i=s.pop();
          int j=s.pop();
          if(mat[i][j]==0){
              s.push(i);
          }
          else{
              s.push(j);
          }
       }
       int celeb=s.pop();
       for(int i=0; i<n;i++){
           if(i!=celeb && (mat[i][celeb]==0 || mat[celeb][i]==1)){
               return -1;
           }
       
       }
           return celeb;
    }
}