class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequencyMap = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the frequency map
            char currentClass = s.charAt(right);
            frequencyMap[currentClass - 'A']++;
            
            // Update the maximum frequency of any single character seen in the current window
            maxFrequency = Math.max(maxFrequency, frequencyMap[currentClass - 'A']);

            // Current window size is (right - left + 1)
            // If the remaining characters to replace exceed k, shrink the window from the left
            if ((right - left + 1) - maxFrequency > k) {
                frequencyMap[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
