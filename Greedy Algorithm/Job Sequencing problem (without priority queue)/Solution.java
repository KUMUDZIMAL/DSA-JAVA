import java.util.ArrayList;
import java.util.Arrays;

class Job {
    int deadline, profit, ID = 0;

    Job(int deadline, int profit) {
        ID++; 
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
            if (deadline[i] > maxDeadline) {
                maxDeadline = deadline[i];
            }
        }


        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));

      
        int[] hash = new int[maxDeadline]; 
        
        int count = 0;
        int totalProfit = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
   
            for (int j = jobs[i].deadline - 1; j >= 0; j--) {
                if (hash[j] == 0) {
                    hash[j] = jobs[i].ID;
                    count++;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }
}