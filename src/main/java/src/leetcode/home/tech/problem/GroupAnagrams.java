package src.leetcode.home.tech.problem;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map= new HashMap<>();

        for(String element:strs){
            String pre = new String(element);
            char[] arr = pre.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> values = map.getOrDefault(key,new ArrayList<String>());
            values.add(element);
            map.put(key,values);
        }
        return new ArrayList<List<String>>(map.values());
    }
}