class NumArray {
    int[] dp = new int[1];
    
    public NumArray(int[] nums) {
        dp = Arrays.copyOf(nums, nums.length);
        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i] + dp[i-1];
        }
        System.out.println(Arrays.toString(dp));
    }
    
    public int sumRange(int i, int j) {
        if(i < 0 || i > j || i > dp.length - 1 || j < 0 || j > dp.length - 1) return 0;
        
        return dp[j] - (i==0?0:dp[i-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
