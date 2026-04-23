class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int a[]=new int[26];
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)-'a']++;
        }
        int k=s1.length();
         int b[]=new int[26];
        for(int i=0;i<s2.length();i++){

            if(i>s1.length()-1){
                if(Arrays.equals(a,b)) return true;
                b[s2.charAt(i)-'a']++;
                b[s2.charAt(i-k)-'a']--;
            }
            else{
                   b[s2.charAt(i)-'a']++;
            }
        }
        if(Arrays.equals(a,b)) return true;
        return false;  
    }
}
