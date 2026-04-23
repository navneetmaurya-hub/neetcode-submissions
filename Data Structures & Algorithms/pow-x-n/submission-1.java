class Solution {
    public double myPow(double x, int n) {
        double ans=1;
        for(int i=0;i<Math.abs(n);i++){
                 ans=ans*x;
        }
        if(n<0){
            return 1/ans;
        }
        return ans;
    }
}
