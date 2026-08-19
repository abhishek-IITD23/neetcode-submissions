class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int ans = 0;
        int[] lastSeen = new int[128]; 
        for(int i=0;i<128;i++){
            lastSeen[i]=-1;
        }
        int l=0;
        for (int r = 0;r < s.length(); r++) {
            char c = s.charAt(r);
            if(lastSeen[c]!=-1 && lastSeen[c]<r){
                 l = Math.max(l, lastSeen[c] + 1); //// Ensure 'l' only moves forward or stays where it is
            }
            lastSeen[c]=r;
            ans = Math.max(ans,r-l+1);
        }
        return ans;
        }
        
    }
