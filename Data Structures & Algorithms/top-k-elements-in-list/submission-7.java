class Solution {
    static class Pair implements Comparable<Pair> {
        int key, val;
        public Pair(int a, int b) {
            this.key = a;
            this.val = b;
        }
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
        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }
            else{
                map.put(num,map.get(num)+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove().key;
        }

        return ans;
    }
}

