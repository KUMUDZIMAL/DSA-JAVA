// Time Complexity:
// O(n) (single loop through prices).

// Space Complexity:
// O(1) (only two variables used: minPrice, maxProfit).

public class Optimal {
  
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
    
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;  // update min price
                } else if (price - minPrice > maxProfit) {
                    maxProfit = price - minPrice;  // update max profit
                }
            }
    
            return maxProfit;
        }
    }
    

