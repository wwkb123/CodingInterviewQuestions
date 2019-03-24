class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, 0, new LinkedList<>(), result);
        return result;
    }
    
    public void combinationSum(int[] candidates, int target, int startIndex, int sum, LinkedList<Integer> combination, List<List<Integer>> result){
        if(sum > target){
            return;
        }
        else if(sum == target){
            List<Integer> list = new ArrayList<>();
            for(int num : combination){
                list.add(num);
            }
            result.add(list);
        }else{
            for(int i = startIndex; i < candidates.length; i++){
                sum += candidates[i];
                if(sum > target) break;
                combination.add(candidates[i]);
                combinationSum(candidates, target, i, sum, combination, result);
                combination.pollLast();
                sum -= candidates[i];
            }
           
        }
    }
}
