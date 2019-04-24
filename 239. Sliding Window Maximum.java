class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        if(nums.length == 0) return new int[0];
        
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return Integer.compare(i2, i1);
            }
        });
        
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        
        result[0] = queue.peek();
        
        for(int i = k; i < nums.length; i++){
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            result[i-k+1] = queue.peek();
        }
        
        return result;
    }
}
