class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return result;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    search(grid, i, j);
                    result++;
                }
            }
        }
        return result;
        
    }
    
    public void search(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) return;
        if(grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        
        search(grid, i - 1, j);
        search(grid, i + 1, j);
        search(grid, i, j - 1);
        search(grid, i, j + 1);
        
    }
}
