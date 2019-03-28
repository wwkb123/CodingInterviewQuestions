class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] count = {0};
        
        for(int i = 0; i < s.length(); i++){
            extendString(s, i, i, count);  //odd
            extendString(s, i, i+1, count); //even
        }
        
        return count[0];
    }
    
    public void extendString(String s, int left, int right, int[] count){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count[0]++;
            left--;
            right++;
        }
    }
    
}
