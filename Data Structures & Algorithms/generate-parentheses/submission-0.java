class Solution {
   public static void dfs(int n,int open,int close,List<String>li,String ans){
      if(ans.length() == n*2){
         li.add(ans);
         return;
      }  
      for(int i=0;i<=1;i++){
         if(i==0){
           if(open < n){
              dfs(n,open+1,close,li,ans+'(');
           }
         }
         else {
           if(close < open){
              dfs(n,open,close+1,li,ans+')');
           }
         }
      }
   }

    public List<String> generateParenthesis(int n) {
       List<String>li=new ArrayList<>();
       dfs(n,0,0,li,""); 
       return li;
    }
}
