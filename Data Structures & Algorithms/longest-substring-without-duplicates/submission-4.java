class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int ans=0;
        if(s==null || s.length()==0) return 0;
        int[] seen = new int[128]; 
        for(int r=0;r<s.length();r++){
            while(seen[s.charAt(r)]>0){
                seen[s.charAt(l)]--;
                l++;
            }
                seen[s.charAt(r)]++;
                if(r-l+1 > ans) ans = r-l+1;

            }
            return ans;
        }
        
    }
