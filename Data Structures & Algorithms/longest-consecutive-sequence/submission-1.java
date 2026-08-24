class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int longestStreak = 1;
        for(int num : nums) set.add(num);
        for(int num : nums){
            if(!set.contains(num-1)){
                int current = num;
                int currStreak = 1;
                while(set.contains(current+1)){
                    current++;
                    currStreak++;
                }
                longestStreak = Math.max(currStreak,longestStreak);
            }
        }
        return longestStreak;
    }
}
