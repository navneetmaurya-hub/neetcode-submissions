class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        int count = map.size();
        int start = 0, end = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while(end < s.length()){

            // Expansion
            char ch = s.charAt(end);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 0){
                    count--;
                }
            }

            // Shrinking
            while(count == 0){

                int len = end - start + 1;

                if(len < minLen){
                    minLen = len;
                    minStart = start;
                }

                char left = s.charAt(start);

                if(map.containsKey(left)){
                    map.put(left, map.get(left) + 1);

                    if(map.get(left) == 1){
                        count++;
                    }
                }

                start++;
            }

            end++;
        }

        if(minLen == Integer.MAX_VALUE) return "";

        return s.substring(minStart, minStart + minLen);
    }
}
