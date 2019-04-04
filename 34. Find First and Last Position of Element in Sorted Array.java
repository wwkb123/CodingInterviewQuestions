class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[]{-1,-1};
        List<Integer> targets = new ArrayList<>();
        search(nums, 0, nums.length-1, target, result);
        
        return result;
    }
    
    public void search(int[] nums, int l, int r, int target, int[] result){
        if(l <= r){
            
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                result[0] = result[0] == -1 ? mid : Math.min(result[0], mid);
                result[1] = result[1] == -1 ? mid : Math.max(result[1], mid);
            }
            if(nums[r] < target) return;
            
            if(nums[l] > target) return;
            
            search(nums, mid+1, r, target, result);
            search(nums, l, mid - 1, target, result);
        }
    }
}
