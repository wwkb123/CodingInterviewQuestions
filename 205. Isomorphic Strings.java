class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        if("".equals(s) && "".equals(t)) return true;
        if("".equals(s) || "".equals(t)) return false;
        if(s.equals(t)) return true;
        
        HashMap<Character, Character> hm = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            if(hm.containsKey(c)){
                if(hm.get(c) != c2) return false;
            }else if(hm.containsValue(c2)){
                return false;
            }else{
                hm.put(c, c2);
            }
        }
        
        return true;
    }
}
