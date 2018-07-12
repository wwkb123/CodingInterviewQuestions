
/*

Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764. 
The sum of the squared divisors is 2500 which is 50 * 50, a square!

Given two integers m, n (1 <= m <= n) we want to find all integers between m and n whose sum of squared divisors is itself a square. 42 is such a number.

The result will be an array of arrays or of tuples (in C an array of Pair) or a string, each subarray having two elements, 
first the number whose squared divisors is a square and then the sum of the squared divisors.

#Examples:

list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --> [[42, 2500], [246, 84100]]

*/

import java.util.ArrayList;
public class SumSquaredDivisors {
	
	public static String listSquared(long m, long n) {
     String result = "[";
		 for(long i=m;i<=n;i++){
       ArrayList<Long> divisors = new ArrayList<Long>();
       divisors.add((long)1*1);
       for(long j=2;j<=i;j++)
         if(i%j==0)
           divisors.add(j*j);
       long sum = 0;
       for(long num:divisors) sum += num;
       if(((long)Math.sqrt(sum) * (long)Math.sqrt(sum))==sum)
         if(result.length()==1)
           result = result + "["+i+", "+sum+"]";
         else
           result = result + ", " + "["+i+", "+sum+"]";
     
     }
     result = result+"]";
     return result;
	}
}