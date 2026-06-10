
    class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Brute Force Approach
        
        // int i = 0;
        // int j = 0; 
        // int l = m;
        // while (i < m && j < n) {

        //     if (nums1[i] <= nums2[j]) {
        //         i++;
        //     } else {

        //         for (int k = m; k > i; k--) {
        //             nums1[k] = nums1[k - 1];
        //         }

        //         nums1[i] = nums2[j];

        //         i++;
        //         j++;
        //         m++;
        //         l++; // nums1 me ek valid element badh gaya
        //     }
        // }

        // while (j < n) {
        //     nums1[l] = nums2[j];
        //     l++;
        //     j++;
        // }
  

        int i = m - 1;      // last valid element of nums1
        int j = n - 1;      // last element of nums2
        int k = m + n - 1;  // last position of nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
      