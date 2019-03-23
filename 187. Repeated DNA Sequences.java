class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int n = s.length();
        for(int i = 0, j = 9; j < n; i++, j++){
            String seq = s.substring(i,j+1);
            if(!hm.containsKey(seq)){
                hm.put(seq, 1);
            }else{
                hm.put(seq, hm.get(seq) + 1);
            }
        }
        
        for(String seq : hm.keySet()){
            if(hm.get(seq) > 1) result.add(seq);
        }
        
        return result;
    }
}
