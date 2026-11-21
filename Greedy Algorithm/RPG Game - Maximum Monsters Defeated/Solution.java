import java.util.*;

class Solution {
    public static int maxMonstersDefeated(int[] power,int[] bonus,int e){
          int count=0;
          int m=power.length;
          int[][] monsters = new int[m][2];

        for (int i = 0; i <m; i++) {
            monsters[i][0] = power[i];
            monsters[i][1] = bonus[i];
        }
Arrays.sort(monsters, (a, b) -> 
    Integer.compare(a[0], b[0])
);
        for(int i=0;i<m;i++){
        if(e>=monsters[i][0]){
            count++;
            e=e+monsters[i][1];
        }

        }
        return count;
    }
    
public static void main(String[] args) {
    
int[] power = {50, 40, 30, 20, 10};
int[] bonus = {10, 20, 30, 40, 50};
int e = 10;

        System.out.println(maxMonstersDefeated(power,bonus,e));
    }
}