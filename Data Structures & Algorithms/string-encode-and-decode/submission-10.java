class Solution {

    public String encode(List<String> strs) {
        String ans="";
       for(int i = 0; i < strs.size(); i++){
            String s = strs.get(i);
            ans = ans + s.length() + "#" + s;
        }
      return ans;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            j++;
            list.add(str.substring(j, j + length));

            i = j + length;
        }

        return list;
    }
}
