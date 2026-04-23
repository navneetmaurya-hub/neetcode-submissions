
class Solution {
    public static class Pair{
        int a,b,c;
        public Pair(int p,int q,int r){
            this.a=p;
            this.b=q;
            this.c=r;
        }
        public boolean equals(Object o){
            if(this==o) return true;
            if(o==null || getClass()!=o.getClass()) return false;
            Pair p=(Pair)o;
            return this.a==p.a && this.b==p.b && this.c==p.c;
        }
        public int hashCode(){
            return Objects.hash(a,b,c);
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>li=new ArrayList<>();
        HashSet<Pair>hs=new HashSet<>();
      for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums.length;j++){
            for(int k=0;k<nums.length;k++){
                if(i != j && j != k && i != k && nums[i]+nums[j]+nums[k]==0){
                    List<Integer>li1=new ArrayList<>();
                    li1.add(nums[i]);
                     li1.add(nums[j]);
                     li1.add(nums[k]);
                     Collections.sort(li1);
                    hs.add(new Pair(li1.get(0),li1.get(1),li1.get(2)));
                }
            }
        }
      }
      for(Pair w:hs){
        List<Integer>lii=new ArrayList<>();
        lii.add(w.a);
        lii.add(w.b);
        lii.add(w.c);
        li.add(lii);
      }
      return li;  
    }
}
