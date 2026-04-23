class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>hs=new HashSet<>();
      while(n!=1){
        int k=n;
        int sum=0;
        while(k!=0){
            int d=k%10;
            sum=sum+d*d;
            k=k/10;
        }
        if(hs.contains(sum)) return false;
        hs.add(sum);
        n=sum;
        if(n==1) return true;
      }
      return true; 
    }
}
