class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Convert to char array and sort alphabetically
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = String.valueOf(chars);
            
            // If key doesn't exist, create a new list. Then add the original string.
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }
        
        // Return the grouped values as a list of lists
        return new ArrayList<>(map.values());
    }
}
