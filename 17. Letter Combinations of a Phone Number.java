class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits.equals("")) return result;
        
        String[] keys = new String[10];
        keys[0] = " ";
        keys[1] = "*";
        keys[2] = "abc";
        keys[3] = "def";
        keys[4] = "ghi";
        keys[5] = "jkl";
        keys[6] = "mno";
        keys[7] = "pqrs";
        keys[8] = "tuv";
        keys[9] = "wxyz";
        
        helper("", keys, digits, 0, result);
        
        return result;
    }
    
    public void helper(String s, String[] keys, String digits, int index, List<String> result){
        if(index == digits.length()){
            result.add(s);
            return;
        }
        int i = digits.charAt(index) - '0';
        for(char c : keys[i].toCharArray()){
            s = s + c;
            helper(s, keys, digits, index + 1, result);
            s = s.substring(0, s.length() - 1);
        }
        
    }

}
