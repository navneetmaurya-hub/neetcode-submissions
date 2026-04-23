class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int stspeed=1,endspeed=0;
        for(int i:piles){
            endspeed=Math.max(endspeed,i);
        }
        
       while(stspeed<=endspeed){
          int sum=0;
          int mid=stspeed+(endspeed-stspeed)/2;
          for(int i=0;i<piles.length;i++){
            sum += Math.ceil((double)piles[i] / mid);
          }
          if(h>=sum){
            
             endspeed=mid-1;
          }
          else{
            stspeed=mid+1;
          }
       }
       return stspeed; 
    }
}
