class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[n-1];
        Arrays.sort(nums);
        
        for(int i = 0; i < n - 2; i++){
            int start = i + 1;
            int end = n - 1;
            while(start < end){
                int num = nums[i] + nums[start] + nums[end];
                if(num < target) start++;
                else end--;
                if(Math.abs(num - target) < Math.abs(result - target)) result = num;
                if(num == target) return num;
            }
        }
        return result;
    }
}
