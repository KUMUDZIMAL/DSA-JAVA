import java.util.*;

class Solution {
    public int minPlatform(int arr[], int dep[]) {
Arrays.sort(arr);
Arrays.sort(dep);
int n=arr.length;
int i=0,j=0;
int count=0;
int maxCount=0;
while(i<n){
    if(arr[i]<=dep[j]){
        count++;
        i=i+1;
    }
    else{
        count--;
        j=j+1;
        
    }
    maxCount=Math.max(maxCount,count);
    
}
return maxCount;
    }
}
