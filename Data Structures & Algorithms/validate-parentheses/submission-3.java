class Solution {
    public boolean isValid(String s) {
        if(s.length()==1) return false;
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<s.length();i++){
         if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
            sb.append(s.charAt(i));
         }
         else{
            int w=sb.length()-1;
            if(!sb.isEmpty() && s.charAt(i)==')' && sb.charAt(w)=='('){
               sb.delete(w,w+1);
            }
            else if(!sb.isEmpty() && s.charAt(i)=='}' && sb.charAt(w)=='{'){
                sb.delete(w,w+1);
            }
           else if(!sb.isEmpty() && s.charAt(i)==']' && sb.charAt(w)=='['){
                sb.delete(w,w+1);
            }
            else{
                return false;
            }
         }
      }
      if(sb.length()!=0) return false;
      return true;  
    }
}
