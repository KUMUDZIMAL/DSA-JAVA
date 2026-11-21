import java.util.*;
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
    int m=boxTypes.length;
    int maxProfit=0;
    // Sort by units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
       for(int i=0;i<m;i++){
            
         if(boxTypes[i][0]<truckSize){
    
            maxProfit+=boxTypes[i][0]*boxTypes[i][1];
            truckSize-=boxTypes[i][0];
        
     
         }
         else{
              maxProfit+=truckSize*boxTypes[i][1];  
                break;
         }
       }
       return maxProfit;
       
    }
}