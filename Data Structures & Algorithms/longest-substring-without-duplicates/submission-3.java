class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=1;
        if(s.length()==0) return 0;
        HashSet<Character>hs=new HashSet<>(); 
        int i=0,j=0;
        while(i<s.length()){
            if( j<s.length() && !hs.contains(s.charAt(j))){
                hs.add(s.charAt(j));
                j++;
            }
            else{
                ans=Math.max(ans,hs.size());
                hs=new HashSet<>();
                i++;
                j=i;
            }
        }
        return ans;
    }
}
