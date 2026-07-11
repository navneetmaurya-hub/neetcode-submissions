class Solution {
    public static void atlantic(int i,int j,int curr,int[][]heights,boolean vatlantic[][]){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || vatlantic[i][j]) return;
        if(heights[i][j] < curr) return;
        vatlantic[i][j]=true;
        curr=heights[i][j];
        atlantic(i-1,j,curr,heights,vatlantic);
        atlantic(i+1,j,curr,heights,vatlantic);
        atlantic(i,j-1,curr,heights,vatlantic);
        atlantic(i,j+1,curr,heights,vatlantic);
    }

    public static void pacific(int i,int j,int curr,int[][]heights,boolean vpacific[][]){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || vpacific[i][j]) return;
        if(heights[i][j] < curr) return;
        vpacific[i][j]=true;
        curr=heights[i][j];
        pacific(i-1,j,curr,heights,vpacific);
        pacific(i+1,j,curr,heights,vpacific);
        pacific(i,j-1,curr,heights,vpacific);
        pacific(i,j+1,curr,heights,vpacific);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> li=new ArrayList<>();
        int k=0;
        boolean vpacific[][]=new boolean[heights.length][heights[0].length];
        boolean vatlantic[][]=new boolean[heights.length][heights[0].length];

        // Left boundary
        for(int i=0;i<heights.length;i++){
            if(!vpacific[i][0]){
                pacific(i,0,heights[i][0],heights,vpacific);
            }
        }

        // Top boundary
        for(int j=0;j<heights[0].length;j++){
            if(!vpacific[0][j]){
                pacific(0,j,heights[0][j],heights,vpacific);
            }
        }

        // Bottom boundary
        for(int j=0;j<heights[0].length;j++){
            if(!vatlantic[heights.length-1][j]){
                atlantic(heights.length-1,j,heights[heights.length-1][j],heights,vatlantic);
            }
        }

        // Right boundary
        for(int i=0;i<heights.length;i++){
            if(!vatlantic[i][heights[0].length-1]){
                atlantic(i,heights[0].length-1,heights[i][heights[0].length-1],heights,vatlantic);
            }
        }

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(vatlantic[i][j] && vpacific[i][j]){
                    List<Integer> lii=new ArrayList<>();
                    lii.add(i);
                    lii.add(j);
                    li.add(lii);
                }
            }
        }

        return li;
    }
}
