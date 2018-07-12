/*

There is an array with some numbers. All numbers are equal except for one. Try to find it!

Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
It’s guaranteed that array contains more than 3 numbers.

*/


import java.util.HashMap;
 public class FindUniqueNum {
    public static double findUniq(double arr[]) {
      HashMap<Double,Integer> myMap = new HashMap<Double,Integer>();
      int count = 0;
      for(int i = 0; i < arr.length; i++){
         if(!myMap.containsKey(arr[i])){
           myMap.put(arr[i],1);
         }else{
           count = myMap.get(arr[i]);
           myMap.put(arr[i],count+1);
         }
        }
        for(int i = 0; i < arr.length; i++){
          if(myMap.get(arr[i])==1){
            return arr[i];
          }
       }
       
       return 0.0;
    }
}