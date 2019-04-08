class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > 0) nums[i] += nums[i-1];
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > result) result = nums[i];
        }
        
        return result;
    }
    
}
