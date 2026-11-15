    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
        int j=0;
        int[] result = new int[n-k+1];
        Deque<Integer> d=new ArrayDeque<>();
        for(int i=0;i<n;i++){
        if(!d.isEmpty() && d.peekFirst()<=i-k){
            d.pollFirst();
        }
        while(!d.isEmpty() && nums[d.peekLast()]<nums[i]){
            d.pollLast();
        }
              d.offerLast(i);
        if(i>=k-1){
            result[j++]=nums[d.peekFirst()];
        }
        }
        return result;
    }}