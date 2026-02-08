import java.util.*;

class Solution {

    class data {
        int start, end, pos;

        data(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public int maxMeetings(int start[], int end[]) {

        int n = start.length;
        data[] arr = new data[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new data(start[i], end[i], i + 1);
        }

        
        Arrays.sort(arr, (a, b) -> Integer.compare(a.end, b.end));

        int count = 1;                
        int freetime = arr[0].end;

        for (int i = 1; i < n; i++) {
            if (arr[i].start > freetime) {
                count++;
                freetime = arr[i].end;
            }
        }

        return count;
    }
}
