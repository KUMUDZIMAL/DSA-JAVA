import java.util.*;

class Solution {
    public int minPlatform(int arr[], int dep[]) {
  
      int n=arr.length;
      int platforms=1;
      int maxPlatforms=1;
     Arrays.sort(arr);
     Arrays.sort(dep);
     int i=1;
     int j=0;
     while(i<n && j<n){
         if(arr[i]<=dep[j]){
             platforms++;
              i=i+1;
         }
         else{
             platforms--;
             j=j+1;
         }
         maxPlatforms=Math.max(maxPlatforms,platforms);
     }
     return maxPlatforms;
    }
}
