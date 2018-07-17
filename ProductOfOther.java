/*

This problem was asked by Uber.

Given an array of integers, return a new array such that 

each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1],

the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

*/

class ProductOfOther {
	public static int[] productOfOther(int[] arr, int n){
		int[] result = new int[n];
		int temp = 1;
		
		//initializing
		for(int i = 0;i<n;i++){
			result[i] = 1;
		}
		
		//multiplying numbers on the left
		for(int i=0;i<n;i++){
			result[i] = temp;
			temp = temp*arr[i];
		}
		
		temp = 1; //reset
		
		//multiplying numbers on the right
		for(int i = n-1;i>=0;i--){
			result[i] = result[i]*temp;
			temp = temp*arr[i];
		}
		
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int[] myList = {10,4,1,6,2};
		myList = productOfOther(myList, 5);
		for(int i : myList){
			System.out.println(i);
		}
		// [48, 120, 480, 80, 240]
	}
	
	
	
}