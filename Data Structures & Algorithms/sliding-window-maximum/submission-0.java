class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = 
        new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int arridx = 0;
        for(int i=0;i<nums.length;i++){
            // 1. Add current index to the heap
            maxHeap.add(i);
            
            // 2. Clean up the heap: remove elements that have fallen out of the left side of the window
            while (maxHeap.peek() <= i - k) {
                maxHeap.poll(); 
            }
            
            // 3. Start adding to results once our first window is fully formed
            if (i >= k - 1) {
                ans[arridx++] = nums[maxHeap.peek()]; // peek() gives the max value in the current window
            }
        }
        return ans;
    }
}
