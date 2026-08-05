class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& m) {
        
        int n1 = m.size() , n2 = m[0].size();
        int l = 0 , r = n2-1 , t = 0 , d = n1-1;
        vector<int>ans;
        while(r>=l && d>=t)
        {
            // top
            for(int i=l;i<=r && d>=t;i++) ans.push_back(m[t][i]);
            t++;
            //right
            for(int i=t;i<=d && r>=l;i++) ans.push_back(m[i][r]);
            r--;
            //down
            for(int i=r;i>=l && d>=t;i--) ans.push_back(m[d][i]);
            d--;
            //left
            for(int i=d;i>=t && r>=l;i--) ans.push_back(m[i][l]);
            l++;
        }
        return ans;
    }
};
