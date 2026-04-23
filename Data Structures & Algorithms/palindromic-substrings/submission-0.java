class Solution {
    public int countSubstrings(String s) {
       int ans=0;
        for(int i=0;i<s.length();i++){
            String m="";
           for(int j=i;j<s.length();j++){
              m+=s.charAt(j);
              StringBuilder sb=new StringBuilder(m);
              sb.reverse();
              if(m.equals(sb.toString())){
                ans++;
              }
           } 
        }
        return ans; 
    }
}
