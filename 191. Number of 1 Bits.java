public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int one = 1;
        int count = 0;
        if(n == 0) return 0;
        int digit = 0;
        while(digit <= 31){
            if((n & one) != 0) count++;
            one = one << 1;
            digit++;
        }
        
        return count;
    }
}
