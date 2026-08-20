class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        // Array of size 26 for lowercase English letters 
        // (Use size 128 if the input includes all standard ASCII characters)
        int[] count = new int[26];
        
        // Single pass: increment for 's', decrement for 't'
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        // Check if all counts are balanced back to zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        
        return true;
    }
}
