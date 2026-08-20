class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int arridx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i =0;i<nums.length;i++){
            // before new element emter remove all useless element
            if(!dq.isEmpty() && dq.peekFirst()<= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i>=k-1){
                ans[arridx++]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
