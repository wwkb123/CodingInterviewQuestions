class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return max;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0) continue;
                max = Math.max(max, getArea(grid, i, j));
            }
        }
        
        return max;
    }
    
    public int getArea(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + getArea(grid, i - 1, j) + getArea(grid, i + 1, j) + getArea(grid, i, j - 1) + getArea(grid, i, j + 1);
    }
}
