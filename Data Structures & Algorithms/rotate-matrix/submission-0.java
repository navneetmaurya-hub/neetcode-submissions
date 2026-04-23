class Solution {
    public static void dfs(int[][] matrix,Queue<Integer>q,int i,int j){
        for(int k=matrix.length-1; k>=0;k--){
            q.add(matrix[k][j]);
        }
    }
    public static void dfs1(int[][] matrix,Queue<Integer>q,int i,int j){
        for(int k=0; k<matrix[0].length;k++){
            matrix[i][k]=q.remove();
        }
    }
    public void rotate(int[][] matrix) {
    Queue<Integer>q=new LinkedList<>();
    int k=matrix.length-1;
    for(int i=0;i<matrix[0].length;i++){
        dfs(matrix,q,k,i);
    } 
     for(int i=0;i<matrix.length;i++){
        dfs1(matrix,q,i,0);
    }
    }
}
