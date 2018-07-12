/*

You have to create a function that takes a positive integer number and returns the next bigger number formed by the same digits:

NextBiggerNumber.nextBiggerNumber(12)==21
NextBiggerNumber.nextBiggerNumber(513)==531
NextBiggerNumber.nextBiggerNumber(2017)==2071
If no bigger number can be composed using those digits, return -1:

NextBiggerNumber.nextBiggerNumber(9)==-1
NextBiggerNumber.nextBiggerNumber(111)==-1
NextBiggerNumber.nextBiggerNumber(531)==-1

*/



import java.util.Arrays;
public class NextBiggerNumber
{
    public static long nextBiggerNumber(long n)
    {
        if (n<10) return -1;
  
  boolean isSwap = false;
  int i;
  String n_str = n + "";
  String[] arr_str = n_str.split("");
  int[] arr = new int[arr_str.length];
  for(int m = 0;m < arr.length; m++){
    arr[m] = Integer.parseInt(arr_str[m]);
  }
  
  for (i = arr.length - 1; i > 0; i--) 
    {
        if (arr[i] > arr[i - 1]) {
            break;
        }
    }
  if(i==0) return -1;
  
  System.out.println(i);
  
   int x = arr[i - 1], min = i;
        for (int j = i + 1; j < arr.length; j++) 
        {
            if (arr[j] > x && arr[j] < arr[min]) 
            {
                min = j;
            }
        }
   
      int temp = arr[i-1];
      arr[i-1] = arr[min];
      arr[min] = temp;
      isSwap = true;
      Arrays.sort(arr,i,arr.length);
    

  n_str = "";
  for(int value :arr){
	  n_str = n_str + value;
  }
 
  return Long.parseLong(n_str);
    }

}