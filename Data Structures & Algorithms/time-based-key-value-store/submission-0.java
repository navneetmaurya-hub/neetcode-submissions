class TimeMap {

    static class Pair{
        String a;
        int b;

        public Pair(String p,int q){
            this.a=p;
            this.b=q;
        }
    }

    HashMap<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)){
            List<Pair> li = new ArrayList<>();
            li.add(new Pair(value,timestamp));
            map.put(key,li);
        }
        else{
            map.get(key).add(new Pair(value,timestamp));
        }

    }

    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) return "";

        List<Pair> li = map.get(key);
        String res = "";

        for(Pair p : li){
            if(p.b <= timestamp){
                res = p.a;
            }
        }

        return res;
    }
}
