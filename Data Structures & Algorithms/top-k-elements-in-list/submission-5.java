

class Solution {

    static class Pair implements Comparable<Pair> {
        int key, val;

        public Pair(int a, int b) {
            this.key = a;
            this.val = b;
        }

        // Sort in descending order of frequency
        @Override
        public int compareTo(Pair p2) {
            if (this.val == p2.val) {
                return p2.key - this.key;   // if frequency same, sort by key descending
            }
            return p2.val - this.val;       // higher frequency first
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Add all elements to priority queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // Step 3: Remove top k frequent elements
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove().key;
        }

        return ans;
    }
}

