class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store the number and its original index: {number: index}
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement is already in the map, we found the pair!
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }
        
        // The problem statement guarantees a valid answer, so this line won't be reached
        return new int[] {};
    }
}
