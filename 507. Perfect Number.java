class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num < 2) return false;
        
        int limit = (int)Math.sqrt(num);
        int i = 2;
        int result = 1;
        while(i <= limit){
            if(num % i == 0) result += (i + num / i);
            i++;
        }
        
        return result == num;
    }
}
