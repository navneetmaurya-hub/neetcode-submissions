class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i : tasks){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int val : map.values()){
            pq.add(val);
        }

        int ans1 = 0;

        while(!pq.isEmpty()){

            int cycle = n + 1;
            int count = 0;

            // process one cycle
            while(cycle > 0 && !pq.isEmpty()){
                int m = pq.remove();
                m--;
                if(m > 0){
                    p.add(m);
                }
                ans1++;
                cycle--;
                count++;
            }
            while(!p.isEmpty()){
                pq.add(p.remove());
            }

            // 🔥 FIX 2: add idle time only if pq not empty
            if(pq.isEmpty()){
                break;
            }

            ans1 += cycle; // remaining idle slots
        }

        return ans1;
    }
}
