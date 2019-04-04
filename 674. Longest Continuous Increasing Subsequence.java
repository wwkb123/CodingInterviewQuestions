class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length <= 1) return nums.length;
        
        int slow = 0;
        int fast = 1;
        int max = 1;
        
        while(fast < nums.length){
            
            if(nums[fast - 1] >= nums[fast]){
                slow = fast;   
            }else{
                max = Math.max(max, fast - slow + 1);
            }
            fast++;
        }
        
        return max;
    }
}
