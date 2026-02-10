import java.lang.Math;
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        int maxPlatforms = 1; 
        for (int i = 0; i < n; i++) {
            
            int platformsNeededNow = 0;
            int checkingTime = arr[i];
       
            for (int j = 0; j < n; j++) {

                if (arr[j] <= checkingTime && dep[j] >= checkingTime) {
                    platformsNeededNow++;
                }
            }
            
            maxPlatforms = Math.max(maxPlatforms, platformsNeededNow);
        }
        return maxPlatforms;
    }
}