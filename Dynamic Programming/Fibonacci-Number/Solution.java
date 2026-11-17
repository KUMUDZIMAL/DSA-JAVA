class Solution {
    public int fib(int n) {
        // Recusrion
    //   if(n<=1){
    //     return n;
    //   }
    //   return fib(n-1)+fib(n-2);

       // Memoization
    //   int[] memo=new int[n+1];
    //   Arrays.fill(memo, -1);
    //   if(n<=1){
    //     return n;
    //   }
    //   if(memo[n]!=-1){
    //     return memo[n];
    //   }
    //   return memo[n]=fib(n-1)+fib(n-2);
    
            //Tabulation
      int[] memo=new int[n+1];
 
      if(n<=1){
        return n;
      }
      memo[0]=0;
      memo[1]=1;
      for(int i=2;i<=n;i++){
        memo[i]=memo[i-1]+memo[i-2];
      }
      return memo[n];

    }
}