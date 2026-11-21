class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int profit=0;
        for(int i=0;i<n-1;i++){
             if(prices[i+1]>prices[i]){
                profit=prices[i+1]-prices[i];
                maxProfit+=profit;
             }

        }
       
        return maxProfit;
    }

}