import java.util.*;

public class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
    
        int m = restrictions.length;
        int[][] allRestrictions = new int[m + 2][2];
        
        allRestrictions[0] = new int[]{1, 0};
        for(int i = 0; i < m; i++) {
            allRestrictions[i + 1] = restrictions[i];
        }
        allRestrictions[m + 1] = new int[]{n, n - 1};
        
        Arrays.sort(allRestrictions, (a, b) -> Integer.compare(a[0], b[0]));
        
        int totalRestrictions = allRestrictions.length;
        
    
        for (int i = 1; i < totalRestrictions; i++) {
            int id1 = allRestrictions[i - 1][0];
            int h1 = allRestrictions[i - 1][1];
            int id2 = allRestrictions[i][0];
            int h2 = allRestrictions[i][1];
            
            allRestrictions[i][1] = Math.min(h2, h1 + (id2 - id1));
        }
        
        for (int i = totalRestrictions - 2; i >= 0; i--) {
            int id1 = allRestrictions[i][0];
            int h1 = allRestrictions[i][1];
            int id2 = allRestrictions[i + 1][0];
            int h2 = allRestrictions[i + 1][1];
            
            allRestrictions[i][1] = Math.min(h1, h2 + (id2 - id1));
        }
        
       
        int maxHeight = 0;
        for (int i = 0; i < totalRestrictions - 1; i++) {
            int id1 = allRestrictions[i][0];
            int h1 = allRestrictions[i][1];
            int id2 = allRestrictions[i + 1][0];
            int h2 = allRestrictions[i + 1][1];
            
     
            int peak = (h1 + h2 + (id2 - id1)) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        
        return maxHeight;
    }
}