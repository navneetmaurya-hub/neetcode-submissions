class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int y=0;
       int st=0,mid=0;
       int end=matrix.length-1;
    
       while(st<=end){
            mid=st+(end-st)/2;
           if(target==matrix[mid][y]){
            return true;
           }
           if(target>matrix[mid][y]){
            st=mid+1;
           }
           else{
            end=mid-1; 
           }
       }
       int r=end;
        if(r< 0) return false;
        
       end=matrix[0].length-1;
       int st1=0;
        while(st1<=end){
            mid=st1+(end-st1)/2;
           if(target==matrix[r][mid]){
            return true;
           }
           if(target>matrix[r][mid]){
            st1=mid+1;
           }
           else{
            end=mid-1; 
           }
       }
       return false;
    }
}
