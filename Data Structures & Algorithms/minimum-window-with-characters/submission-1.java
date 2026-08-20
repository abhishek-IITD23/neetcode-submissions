class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        
        // Use an array for ASCII characters (handles uppercase and lowercase)
        int[] countT = new int[128];
        int[] window = new int[128];
        
        for (char c : t.toCharArray()) {
            countT[c]++;
        }
        
        // Count unique characters needed
        int need = 0;
        for (int count : countT) {
            if (count > 0) need++;
        }
        
        int have = 0;
        int resLen = Integer.MAX_VALUE;
        int resL = -1;
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window[c]++;
            
            // Compare primitive values directly using ==
            if (countT[c] > 0 && window[c] == countT[c]) {
                have++;
            }
            
            while (have == need) {
                // Update result if a smaller window is found
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    resL = l;
                }
                
                char leftChar = s.charAt(l);
                window[leftChar]--;
                
                // Compare primitive values directly using <
                if (countT[leftChar] > 0 && window[leftChar] < countT[leftChar]) {
                    have--;
                }
                l++;
            }
        }
        
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resL, resL + resLen);
    }
}
