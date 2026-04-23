class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]==9){
          StringBuilder sb=new StringBuilder();
          for(int i:digits){
            sb.append(i);
          }
          int k=Integer.parseInt(sb.toString())+1; 
          String m="";
          m=m+k;
          int ans[]=new int[m.length()];
          for(int i=0;i<m.length();i++){
             ans[i]=m.charAt(i)-'0';
          }
          return ans;
        }
        digits[digits.length-1]=digits[digits.length-1]+1;
        return digits;
    }
}
