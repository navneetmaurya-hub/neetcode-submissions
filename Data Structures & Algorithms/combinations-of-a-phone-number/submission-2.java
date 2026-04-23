class Solution {
    public static void combination(String f,String s,List<String>li){
      String ans="";
      for(int i=0;i<f.length();i++){
        ans=ans+f.charAt(i);
        for(int j=0;j<s.length();j++){
            ans=ans+s.charAt(j);
            li.add(ans);
            ans=ans.substring(0,ans.length()-1);
        }
        ans="";
      }
    }
    public static void combination1(List<String>ans1,String s,List<String>li){
      String ans="";
      for(int i=0;i<ans1.size();i++){
        ans=ans+ans1.get(i);
        for(int j=0;j<s.length();j++){
            ans=ans+s.charAt(j);
            li.add(ans);
            ans=ans.substring(0,ans.length()-1);
        }
        ans="";
      }
    }
    public List<String> letterCombinations(String digits) {
      HashMap<Integer,String>map=new HashMap<>();
      map.put(2,"abc");
      map.put(3,"def");
      map.put(4,"ghi");
      map.put(5,"jkl");
      map.put(6,"mno");
      map.put(7,"pqrs");
      map.put(8,"tuv");
      map.put(9,"wxyz");
      List<String>ans=new ArrayList<>();
       if(digits.length()==0) return ans;
       if(digits.length()==1){
         for(char i:map.get(digits.charAt(0)-'0').toCharArray()){
          ans.add(""+i);
         }
         return ans;
       }
      List<List<String>>li=new ArrayList<>();
      for(int i=1;i<digits.length();i++){
        if(i==1){
          combination(map.get(digits.charAt(0)-'0'),map.get(digits.charAt(i)-'0'),ans);
          li.add(new ArrayList<>(ans));
        } 
        else{
          List<String>ans1=new ArrayList<>();
          combination1(li.get(i-2),map.get(digits.charAt(i)-'0'),ans1);
          li.add(new ArrayList<>(ans1));
        }
      }
      return li.get(li.size()-1);
    }
}
