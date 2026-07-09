class Solution {
    static class Pair{
        int a,b;
        public Pair(int c,int d){
            this.a=c;
            this.b=d;
        }
    }
    public static boolean check(int i,int j,int[][] grid,boolean visited[][]){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]==-1 || visited[i][j]==true){
            return false;
        }
        return true;
    }
    public void islandsAndTreasure(int[][] grid) {
      Queue<Pair>q=new LinkedList<>();
      boolean visited[][]=new boolean[grid.length][grid[0].length];
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==0){
                visited[i][j]=true;
                q.add(new Pair(i,j));
            }
        }
      }
      int idx=0;
      while(!q.isEmpty()){
        int size=q.size();
        idx++;
        while(size-->0){
           Pair w=q.remove();
           int i=w.a;
           int j=w.b;
           if(check(i+1,j,grid,visited)){
            grid[i+1][j]=idx;
            visited[i+1][j]=true;
            q.add(new Pair(i+1,j));
           }
           if(check(i,j+1,grid,visited)){
            grid[i][j+1]=idx;
            visited[i][j+1]=true;
            q.add(new Pair(i,j+1));
           }
           if(check(i-1,j,grid,visited)){
            grid[i-1][j]=idx;
            visited[i-1][j]=true;
            q.add(new Pair(i-1,j));
           }
           if(check(i,j-1,grid,visited)){
            grid[i][j-1]=idx;
            visited[i][j-1]=true;
            q.add(new Pair(i,j-1));
           }
        }
      } 
    }
}
