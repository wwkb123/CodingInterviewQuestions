class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        if(triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) return 0;
        dp.add(triangle.get(0));
        int min = Integer.MAX_VALUE;
        constructDP(triangle, dp);
        
        System.out.println(dp);
        for(int num : dp.get(dp.size()-1)){
            min = Math.min(num, min);
        }
      
        return min;
    }
    
    public void constructDP(List<List<Integer>> triangle, List<List<Integer>> dp){
        for(int i = 1; i < triangle.size(); i++){ // for each row in triangle
            dp.add(i, new ArrayList<>());
            
            for(int j = 0; j < triangle.get(i).size(); j++){  // for each elem of the row
                int num = triangle.get(i).get(j);       //elem in i,j of triangle
                int min = Integer.MAX_VALUE;
                if(j-1 >= 0){
                    min = Math.min(num + dp.get(i-1).get(j-1), min);
                    if(dp.get(i).size() <= j) dp.get(i).add(j, min);
                    else dp.get(i).set(j, min);
                }
                if(j < dp.get(i-1).size()){
                    min = Math.min(num + dp.get(i-1).get(j), min);
                    if(dp.get(i).size() <= j) dp.get(i).add(j, min);
                    else dp.get(i).set(j, min);
                }
            }
        }
    }
}
