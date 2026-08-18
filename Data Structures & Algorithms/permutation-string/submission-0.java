class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Initialize the first window
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Check if the initial window matches
        if (matches(s1Count, s2Count)) {
            return true;
        }

        // Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Add the new character entering the window
            s2Count[s2.charAt(i) - 'a']++;
            // Remove the old character leaving the window
            s2Count[s2.charAt(i - len1) - 'a']--;
            
            // Compare frequencies
            if (matches(s1Count, s2Count)) {
                return true;
            }
        }
        
        return false;
    }
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;

    }
}
