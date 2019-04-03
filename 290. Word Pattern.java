class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] str_split = str.split(" ");
        if(pattern.length() == 1 && str_split.length == 0) return true;
        if(pattern.isEmpty() || str_split.length == 0 || str_split.length != pattern.length()) return false;
        
        int pointer = 0;
        HashMap<Character, String> pattern_map = new HashMap<>();
        HashMap<String, Character> str_map = new HashMap<>();
        pattern_map.put(pattern.charAt(0), str_split[0]);
        str_map.put(str_split[0], pattern.charAt(0));
        
        for(int i = 1; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            
            if(pattern_map.containsKey(c)){
                if(!pattern_map.get(c).equals(str_split[i])) return false;
            }else if (str_map.containsKey(str_split[i])){   // don't have in pattern, but in str
                return false;
            }else{          // don't have in pattern and str
                pattern_map.put(c, str_split[i]);
                str_map.put(str_split[i], c);
            }
        }
        return true;
    }
}
