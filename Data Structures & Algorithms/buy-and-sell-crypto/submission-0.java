class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,min=Integer.MAX_VALUE;
        int ans=0;
        for(int x : prices){
            if(x<min) min=x;
            else profit = x-min;
            if(profit>ans) ans =profit;
        }
        return ans;
    }
}
