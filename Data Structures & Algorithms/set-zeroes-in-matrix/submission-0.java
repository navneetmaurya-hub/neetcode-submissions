class Solution {
    static class Pair implements Comparable<Pair>{
        int a,b;
        public Pair(int p,int q){
            this.a=p;
            this.b=q;
        }
        public int compareTo(Pair other){
            return this.a - other.a;
    }
    }
    public static void dfs(int[][] matrix,int i,int j){
        for(int k=0;k<matrix.length;k++){
            matrix[k][j]=0;
        }
        for(int k=0;k<matrix[0].length;k++){
            matrix[i][k]=0;
        }
    }
    public void setZeroes(int[][] matrix) {
    PriorityQueue<Pair>pq=new PriorityQueue<>();
      for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
                pq.add(new Pair(i,j));
            }
        }
      }
      while(!pq.isEmpty()){
        Pair w=pq.remove();
        dfs(matrix,w.a,w.b);
      }  
    }
}
