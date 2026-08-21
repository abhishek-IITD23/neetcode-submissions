class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Frequency array for 26 lowercase English letters
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Convert frequency array into a unique string key
            StringBuilder sb = new StringBuilder();
            for (int val : count) {
                sb.append('#').append(val); // '#' acts as a delimiter
            }
            String key = sb.toString();
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
