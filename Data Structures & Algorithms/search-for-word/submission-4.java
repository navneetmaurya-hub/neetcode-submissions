class Solution {
  static boolean found = false;
  public static void dfs(char[][] board,int i,int j,String word,int idx,String ans[],boolean visit[][]){
    if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || idx>word.length()-1 || found) return;
    if(board[i][j]==word.charAt(idx) && visit[i][j]!=true){
      ans[0]=ans[0]+board[i][j];
      idx++;
      visit[i][j]=true;
    }
    else{
      return;
    }
    if(ans[0].equals(word)){
      found = true;   
      return;
    }
    dfs(board,i,j+1,word,idx,ans,visit);
    dfs(board,i,j-1,word,idx,ans,visit);
    dfs(board,i+1,j,word,idx,ans,visit);
    dfs(board,i-1,j,word,idx,ans,visit);
    if(!found){
      ans[0] = ans[0].substring(0, ans[0].length()-1);
      visit[i][j]=false;
    }
  }

  public boolean exist(char[][] board, String word) {
    boolean visit[][]=new boolean[board.length][board[0].length];
    String ans[]=new String[1];
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        ans[0]="";
        found = false; 
        if(board[i][j]==word.charAt(0)){
            dfs(board,i,j,word,0,ans,visit);
        }
        if(found) return true;
      }
    }
    return false;  
  }
}