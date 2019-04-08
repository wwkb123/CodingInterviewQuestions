class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        
        //last row
        for(int i = 0; i < n; i++){
            dp[m-1][i] = 1;
        }
        
        //last column
        for(int i = 0; i < m; i++){
            dp[i][n-1] = 1;
        }
        
        
        for(int row = m - 2; row >= 0; row--){
            for(int col = n - 2; col >= 0; col--){
                dp[row][col] = dp[row][col+1] + dp[row+1][col];
            }
        }
        
        
        print(dp);
        
        return dp.length > 0 ? dp[0][0] : 0;
    }
    
    public void print(int[][] dp){
        for(int row = 0; row < dp.length; row++){
            System.out.println(Arrays.toString(dp[row]));
        }
    }
}
