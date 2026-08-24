class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length==0) return new int[0];
        int leftProduct = 1;
        int rightProduct = 1;
        int[] ans = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            ans[i] = leftProduct;
            leftProduct*= nums[i];
        }
        rightProduct = nums[nums.length-1];
        for (int i=nums.length-2;i>=0;i--){
            ans[i] = ans[i] * rightProduct;
            rightProduct*= nums[i];
        }
        return ans;
    }
}  
