import java.util.Arrays;
/*
 
Good morning! Here's your coding interview problem for today.

This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. 

In other words, find the lowest positive integer that does not exist in the array. 

The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

*/

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] arr, int size) {
		Arrays.sort(arr);
		if(arr[size-1]<=0) return 1; //if all values are less than 1, 1 is missing
		if(arr[0]>1) return 1; //if all values are greater than 1, 1 is missing
		
		int slow = 0, fast;
		
		//remove all non positive elements from the array
		for(fast = 1; fast < size; fast++){
			if(arr[fast]>0 && arr[fast]!=arr[slow]){
				arr[++slow] = arr[fast];
			}
		}
		
		for(int i=1;i<slow;i++){
			if(arr[i+1]-arr[i]>1) return arr[i]+1;  //return the smaller number + 1
		}
		
		return arr[slow+1]+1;  //no missing numbers between the elements, return the largest number + 1
		
	}

	public static void main(String[] args) {
		int[] arr = {99,3,5,6,3,4,-1,-2,-6,-8,7,8,9,10,10,11,2,3,5,6,6,7,1,-99,-999};
		System.out.println(firstMissingPositive(arr,arr.length));
		
	}

}
