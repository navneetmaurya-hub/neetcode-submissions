class Solution {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);;
       int idx=0;
       for(int i=0;i<s.length();i++){
         if(s.charAt(i)-'0'==1) idx=idx+1;
       } 
       return idx;
    }
}
