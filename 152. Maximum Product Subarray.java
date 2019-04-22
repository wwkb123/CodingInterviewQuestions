class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int globalMax = nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = localMax;
                localMax = localMin;
                localMin = temp;
            }
            localMax = Math.max(nums[i], localMax * nums[i]);
            localMin = Math.min(nums[i], localMin * nums[i]);
            
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
}
