class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     HashMap<String,List<String>>map=new HashMap<>();
     for(String key:strs){
        int count[]=new int[26];
        for(int i=0;i<key.length();i++){
            count[key.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append('#');
            sb.append(count[i]);
        }
        String key1=sb.toString();
        if(!map.containsKey(key1)){
            map.put(key1,new ArrayList<String>());
        }
        map.get(key1).add(key);
     }
      return new ArrayList<>(map.values());   
    }
}
