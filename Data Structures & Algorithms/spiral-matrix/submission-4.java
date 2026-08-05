class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>li=new ArrayList<>();
        int row=0;
        int endrow=matrix.length-1;
        int col=0;
        int endcol=matrix[0].length-1;
        while(row<=endrow && col<=endcol){
            for(int i=col;i<=endcol;i++){
                li.add(matrix[row][i]);
                }
            row++;
            for(int i=row;i<=endrow;i++){
                li.add(matrix[i][endcol]);
                }
            endcol--;
            if(row<=endrow){
                for(int i=endcol;i>=col;i--){
                    li.add(matrix[endrow][i]);
                    }
                }
            endrow--;
            if(col<=endcol){
                for(int i=endrow;i>=row;i--){
                    li.add(matrix[i][col]);
                    }
             }
            col++;
            }
        
        return li;
    }
}
