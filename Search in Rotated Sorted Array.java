class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
