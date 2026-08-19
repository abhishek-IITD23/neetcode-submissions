class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int ans = 0;
        int[] lastSeen = new int[128]; // Tracks 1-based next index placement
        
        for (int r = 0, l = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // Instantly move 'l' to the right of the last duplicate's position
            l = Math.max(l, lastSeen[c]); 
            ans = Math.max(ans, r - l + 1);
            lastSeen[c] = r + 1; // Record next valid starting index
        }
        return ans;
        }
        
    }
