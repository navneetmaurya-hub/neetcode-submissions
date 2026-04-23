class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            String m="";
           for(int j=i;j<s.length();j++){
              m+=s.charAt(j);
              if(m.length()>ans.length()){
                 StringBuilder sb=new StringBuilder(m);
                 sb.reverse();
                 if(m.equals(sb.toString())){
                    ans=m;
                 }
              }
           } 
        }
        return ans;
    }
}
