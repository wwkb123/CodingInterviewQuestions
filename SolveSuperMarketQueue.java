/*

There is a queue for the self-checkout tills at the supermarket. 
Your task is write a function to calculate the total time required for all the customers to check out!

The function has two input variables:

customers: an array (list in python) of positive integers representing the queue. 
Each integer represents a customer, and its value is the amount of time they require to check out.
n: a positive integer, the number of checkout tills.
The function should return an integer, the total time required.

EDIT: A lot of people have been confused in the comments. To try to prevent any more confusion:

There is only ONE queue, and
The order of the queue NEVER changes, and
Assume that the front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
The diagram on the wiki page I linked to at the bottom of the description may be useful.
So, for example:

queueTime([5,3,4], 1)
// should return 12
// because when n=1, the total time is just the sum of the times

queueTime([10,2,3,3], 2)
// should return 10
// because here n=2 and the 2nd, 3rd, and 4th people in the 
// queue finish before the 1st person has finished.

queueTime([2,3,10], 2)
// should return 12
N.B. You should assume that all the test input will be valid, as specified above.

*/
import java.util.Arrays;
public class SolveSuperMarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      int totalTime = 0;
      boolean isFinished = false;
      if(customers.length<1) return 0;
      if(customers.length==1) return customers[0];
      int[] checking = Arrays.copyOfRange(customers,0,n);
       if(n>customers.length){
    	  int max = customers[0];
    	  for(int i=1;i<customers.length;i++){
    		  if(customers[i]>max) max = customers[i];
    	  }
    	  return max;
      }
      int[] waiting = Arrays.copyOfRange(customers,n,customers.length);
        for(int j = 0;!isFinished;j = (j+1)%checking.length){
          if(checking[j]==1){
        	  if(waiting.length>0){
        	 checking[j] = waiting[0];
        	 
        	  }
            if(waiting.length>1){
              waiting = Arrays.copyOfRange(waiting,1,waiting.length);
              }else{
            	  totalTime++;
            	  int max = checking[0];
            	  for(int i=1;i<checking.length;i++){
            		  if(checking[i]>max) max = checking[i];
            	  }
            	  totalTime+=max;
            	  break;
              }
            }
            else{
              checking[j]--;
              
            }
          if(j==n-1){
        	  totalTime++;
          }
          }
      return totalTime;
      
    }
    
}