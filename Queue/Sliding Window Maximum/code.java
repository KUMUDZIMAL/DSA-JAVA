class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Optimal method
        // int n = nums.length;
        // int j=0;
        // int[] result = new int[n-k+1];
        // Deque<Integer> d=new ArrayDeque<>();
        // for(int i=0;i<n;i++){
        // if(!d.isEmpty() && d.peekFirst()<=i-k){
        //     d.pollFirst();
        // }
        // while(!d.isEmpty() && nums[d.peekLast()]<nums[i]){
        //     d.pollLast();
        // }
        //       d.offerLast(i);
        // if(i>=k-1){
        //     result[j++]=nums[d.peekFirst()];
        // }
        // }
        // return result;

        // Brute Force
        int n = nums.length;
        int[] result = new int[n-k+1];
       for(int i=0;i<n-k+1;i++){
            int maxi=nums[i];
        for(int j=i;j<=i+k-1;j++){
        maxi=Math.max(nums[j],maxi);

        }
        result[i]=maxi;
       }
       return result;
    }
}