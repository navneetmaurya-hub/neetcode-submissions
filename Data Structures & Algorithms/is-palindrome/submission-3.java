class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=65 && s.charAt(i)<=90) || (s.charAt(i)>=48 && s.charAt(i)<=57)){
               sb.append(s.charAt(i));
            }
        }
        String ans=sb.toString().toLowerCase();
       int st=0,end=ans.length()-1;
       while(st<=end){
            if(ans.charAt(st)!=ans.charAt(end)) return false;
            st++;
            end--;
        }
       return true;
    }
}
