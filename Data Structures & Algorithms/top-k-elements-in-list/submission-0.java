class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build the Hash Map (Element -> Frequency)
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min-Heap based on the frequency
        // We store the numbers, but order them by their frequencies in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );

        // Step 3: Maintain a heap of size k
        for (int key : countMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the element with the lowest frequency
            }
        }

        // Step 4: Extract the results into an array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
