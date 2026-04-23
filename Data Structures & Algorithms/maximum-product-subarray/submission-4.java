class Solution {
    public int maxProduct(int[] nums) {
     PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
     if(nums.length==1) return nums[0];
     int m=1,n=1;
     int k=nums.length-1;
     int d=0,d1=0;
     for(int i=0;i<nums.length;i++){
        if(nums[i]==0) d++;
        if(nums[i]>0) d1++;
        m=m*nums[i];
        n=n*nums[k--];
        pq.add(m);
        pq.add(n);
     }
     if(d>0 && d1==0) return 0;
     n=1;
     int ans[]=new int[1];
     for(int i=0;i<nums.length;i++){
         if(nums[i]<0 ||nums[i]==0){
            ans[0]=Math.max(ans[0],n);
             n=1;
         }
         else{
            n=n*nums[i];
         }
        if(i==nums.length-1 && nums[i]!=-1){
           ans[0]=Math.max(ans[0],n);
        }
     }
     return Math.max(ans[0],pq.remove());
    }
}
