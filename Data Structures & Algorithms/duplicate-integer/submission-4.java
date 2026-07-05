class Solution {
    public boolean hasDuplicate(int[] nums) {
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int e:nums){
          if(!map.containsKey(e)){
            map.put(e,1);
          } 
          else{
            map.put(e,map.get(e)+1);
          }
       }
       for(Map.Entry<Integer,Integer>m:map.entrySet()){
           if(m.getValue()>1) return true;
       }
       return false;
    }
}