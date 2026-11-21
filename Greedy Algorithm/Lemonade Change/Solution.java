class Solution {
    public boolean lemonadeChange(int[] bills) {
     int n=bills.length;
     int five=0;
     int ten=0;
     int twenty=0;
     int count=0;
  
     for(int i=0;i<n;i++){
        if(bills[i]==5){
          five++;
        }
        else if(bills[i]==10){
         ten++;
        }
        else{
            twenty++;
        }
      
        if(bills[i]>5){
            int remaining=bills[i]-5;
            if(remaining==5){
              if(five>0){
                count++;
                five--;
              }}
            if(remaining==10){
              if(ten>0){
                count++;
                ten--;
              }
            else if(five>=2){
                count++;
                five=five-2;
              }
            }
                    if(remaining==15){
              if(ten>0 && five>0){
                count++;
                ten--;
                five--;
              }
              else if(five>=3){
                          count++;
             
                five=five-3;
              }
            }
        }
        else{
              count++;
        }
     }
     return count==n?true:false;
    }
}     