class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int area=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
             
        area=Math.min(height[i],height[j])*(j-i);
        max=Math.max(max,area);
            }
        }
        return max;
    }
}
