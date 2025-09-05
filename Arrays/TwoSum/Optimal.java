// Time Complexity: O(n)
// We loop through the array once (n elements).
// Each map.containsKey() and map.put() operation is O(1) average case (hash table).

// Space Complexity: O(n)
// In the worst case, we store all n numbers in the HashMap before finding the solution.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
    
        }
        return new int[] {};
    }

}

