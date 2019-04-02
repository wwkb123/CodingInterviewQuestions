class Solution {

    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0) return null;
        
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, new ArrayList<Integer>(), result, 1, 0);
        return result;
    }
    
    public void combinationSum3(int k, int n, List<Integer> chosen, List<List<Integer>> result, int count, int sum){
        if(chosen.size() > k) return;
        if(sum == n && chosen.size() == k){

            result.add(new ArrayList<>(chosen));
            
        }else{
            for(int i = count; i < 10; i++){
                chosen.add(i);
                combinationSum3(k, n, chosen, result, i + 1, sum + i);
                chosen.remove(chosen.size()-1);
            }
        }
    }
    
}
