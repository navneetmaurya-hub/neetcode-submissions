class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[]=new int[2];
       int st=0;
       int end=0;
       while(st<numbers.length-1){
        end++;
           if(numbers[st]+numbers[end]==target){
               ans[0]=st+1;
               ans[1]=end+1;
               break;
           }
           if(end==numbers.length-1){
            st++;
            end=st;
           } 
       }
       return ans;
    }
}
