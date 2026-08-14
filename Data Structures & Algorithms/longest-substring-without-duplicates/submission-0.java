class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int ans =0;
        HashMap<Character,Integer>hmap = new HashMap<>();
        while(r<s.length()){
            char ch = s.charAt(r);
            if(hmap.containsKey(ch) && hmap.get(ch)>=l){
                l = hmap.get(ch)+1;
            }
            hmap.put(ch,r);
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}
