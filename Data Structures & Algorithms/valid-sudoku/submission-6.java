class Solution {

    public static boolean dfs(char[][] board,int i,int j){
        int d = 0;
        HashSet<Integer> hs = new HashSet<>();

        // Row Check
        for(int k=0;k<9;k++){
            if(board[i][k] != '.'){
                hs.add(board[i][k] - '0');
                d++;
            }
        }
        if(d != hs.size()) return false;

        d = 0;
        HashSet<Integer> hs1 = new HashSet<>();

        // Column Check (FIXED LINE)
        for(int k=0;k<9;k++){
            if(board[k][j] != '.'){
                hs1.add(board[k][j] - '0');  // ✅ fixed
                d++;
            }
        }
        if(d != hs1.size()) return false;

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        int k;

        // row01
        HashSet<Integer>hs2=new HashSet<>();
        k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]!='.'){
                    hs2.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs2.size()) return false;

        // row02
        HashSet<Integer>hs3=new HashSet<>();
        k=0;
        for(int i=0;i<3;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]!='.'){
                    hs3.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs3.size()) return false;

        // row03
        HashSet<Integer>hs4=new HashSet<>();
        k=0;
        for(int i=0;i<3;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]!='.'){
                    hs4.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs4.size()) return false;

        // row11
        HashSet<Integer>hs5=new HashSet<>();
        k=0;
        for(int i=3;i<6;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]!='.'){
                    hs5.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs5.size()) return false;

        // row12
        HashSet<Integer>hs6=new HashSet<>();
        k=0;
        for(int i=3;i<6;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]!='.'){
                    hs6.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs6.size()) return false;

        // row13
        HashSet<Integer>hs7=new HashSet<>();
        k=0;
        for(int i=3;i<6;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]!='.'){
                    hs7.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs7.size()) return false;

        // row21
        HashSet<Integer>hs8=new HashSet<>();
        k=0;
        for(int i=6;i<9;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]!='.'){
                    hs8.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs8.size()) return false;

        // row22
        HashSet<Integer>hs9=new HashSet<>();
        k=0;
        for(int i=6;i<9;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]!='.'){
                    hs9.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs9.size()) return false;

        // row23
        HashSet<Integer>hs10=new HashSet<>();
        k=0;
        for(int i=6;i<9;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]!='.'){
                    hs10.add(board[i][j]-'0');
                    k++;
                }
            }
        }
        if(k!=hs10.size()) return false;

        // Row & Column Check Using dfs (FIXED LOGIC)
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(!dfs(board,i,j)) return false;   // ✅ fixed
            }
        }

        return true;
    }
}
