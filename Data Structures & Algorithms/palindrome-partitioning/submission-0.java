class Solution {
    public static boolean check(String m){
        StringBuilder sb=new StringBuilder(m);
        sb.reverse();
        if(m.equals(sb.toString())) return true;
        return false;
    }
    public static void dfs(String s,List<List<String>>li,List<String>lii,int i){
       if(s.length()==0){
        li.add(new ArrayList<>(lii));
        return;
       }
       for(int j=0;j<s.length();j++){
        String sub=s.substring(0,j+1);
        if(check(sub)){
            lii.add(sub);
            dfs(s.substring(j+1),li,lii,j+1);
            lii.remove(lii.size()-1);
        }
       }
    }
    public List<List<String>> partition(String s) {
      List<List<String>>li=new ArrayList<>();
      List<String>lii=new ArrayList<>();
      dfs(s,li,lii,0);  
      return li;
    }
}
