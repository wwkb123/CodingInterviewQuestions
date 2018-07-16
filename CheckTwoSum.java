/*

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

*/

class CheckTwoSum {
  public static boolean inList(int[] arr, int k){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i< arr.length;i++){
			if(!set.contains(arr[i])){
				set.add(k-arr[i]);
			}else{
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		int[] myList = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(inList(myList,20));	
	}
}