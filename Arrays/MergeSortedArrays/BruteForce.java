// Time Complexity: O((m+n) log(m+n)) (sorting lag raha hai)
// Space Complexity: O(1) (in-place sort)

import java.util.Arrays;

public class BruteForce {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    for(int i=0;i<n;i++){
    nums1[m+i]=nums2[i];
}

Arrays.sort(nums1);
    }
}

