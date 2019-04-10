class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null) return result;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void backtrack(int[] candidates, int target, int start, int sum, List<Integer> combination, List<List<Integer>> result){
        if (sum == target) {
            result.add(new ArrayList<>(combination));
            
        } else if (start == candidates.length || sum > target) return;
        else {
            for(int i = start; i < candidates.length; i++){
                if (i > start && candidates[i] == candidates[i-1]) continue;
                
                combination.add(candidates[i]);
                
                backtrack(candidates, target, i + 1, sum + candidates[i], combination, result);
                
                combination.remove(combination.size() - 1);
            }
        }
    }
}
