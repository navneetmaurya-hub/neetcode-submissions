// class Solution {
//     public static class Pair implements Comparable <Pair>{
//         int a,b;
//         public Pair(int p1,int q){
//             this.a=p1;
//             this.b=q;
//         }
//         public int compareTo(Pair p2){
//             return p2.a-this.a;  // desending order
//         }
//         // @overide 
//         public boolean equals(Object o){
//             if(this==o) return true;
//             if(o==null || getClass()!=o.getClass()) return false;
//             Pair p=(Pair)o;
//             return this.a==p.a && this.b==p.b;
//         }
//         // 
//         public int hashCode(){
//             return Objects.hash(a,b);
//         }
//     }
//     public int[] maxSlidingWindow(int[] nums, int k) {
//      PriorityQueue<Pair>pq=new PriorityQueue<>();
//      int ans[]=new int[(nums.length-k)+1];
//      int idx=0;
//      for(int i=0;i<k;i++){
//         pq.add(new Pair(nums[i],i));
//      }
//      Pair w=pq.remove();
//      ans[idx++]=w.a;
//      pq.add(new Pair(w.a,w.b));
//      for(int i=k;i<nums.length;i++){
//          pq.add(new Pair(nums[i],i));
//          pq.remove(new Pair(nums[i-k],i-k));
//          w=pq.remove();
//          ans[idx]=w.a;
//          idx++;
//          pq.add(new Pair(w.a,w.b));
//      }
//      return ans;
//     }
// }

class Solution {

    public static class Pair implements Comparable<Pair> {
        int a,b;

        public Pair(int p1,int q){
            this.a=p1;
            this.b=q;
        }

        public int compareTo(Pair p2){
            return p2.a - this.a; // descending
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[] = new int[nums.length - k + 1];
        int idx = 0;

        for(int i=0;i<nums.length;i++){

            pq.add(new Pair(nums[i], i));

            // remove elements outside window
            while(pq.peek().b <= i - k){
                pq.remove();
            }

            if(i >= k-1){
                ans[idx++] = pq.peek().a;
            }
        }

        return ans;
    }
}
