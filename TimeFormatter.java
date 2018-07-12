
/*
Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.

The function must accept a non-negative integer. If it is zero, it just returns "now". 
Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.

It is much easier to understand with an example:

TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
For the purpose of this Kata, a year is 365 days and a day is 24 hours.

Note that spaces are important.

Detailed rules
The resulting expression is made of components like 4 seconds, 1 year, etc. 
In general, a positive integer and one of the valid units of time, separated by a space. 
The unit of time is used in plural if the integer is greater than 1.

The components are separated by a comma and a space (", "). Except the last component, 
which is separated by " and ", just like it would be written in English.

A more significant units of time will occur before than a least significant one. 
Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.

Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.

A component will not appear at all if its value happens to be zero. 
Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.

A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, 
but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.


*/



public class TimeFormatter {
    
    public static String formatDuration(int input) {
        if(input == 0) return "now";
        int count = 0;
        String format = "";
        int[] duration = new int[5]; // [years, days, hours, minutes, seconds]
        
        for(int i = 0; i < 5; i++){
          switch(i){
            case 0:
              duration[i] = input / (365*24*60*60); //years
              input = input % (365*24*60*60);
              if(duration[i]!=0){
                count++;
                format = (duration[i]==1)?duration[i]+" year":duration[i]+" years";
              }
              break;
            case 1:
              duration[i] = (input)/86400; //days
              input = input % 86400;
              if(duration[i]!=0){
                count++;
                String prefix = (countPrev(duration,i)>0)?", ":"";
                String temp = (duration[i]==1)?duration[i]+" day":duration[i]+" days";
                format = format + prefix + temp;
              }
              break;
            case 2:
              duration[2] = input/3600; //hours
              input = input % 3600;
              if(duration[i]!=0){
                count++;
                String prefix = (countPrev(duration,i)>0)?", ":"";
                String temp = (duration[i]==1)?duration[i]+" hour":duration[i]+" hours";
                format = format + prefix + temp;
              }
              break;
            case 3:
              duration[3] = input/60; //minutes
              input = input % 60;
              if(duration[i]!=0){
                count++;
                String prefix = (countPrev(duration,i)>0)?", ":"";
                String temp = (duration[i]==1)?duration[i]+" minute":duration[i]+" minutes";
                format = format + prefix + temp;
              }
              break;
            case 4:
              duration[4] = input; //seconds
              if(duration[i]!=0){
                count++;
                String prefix = (countPrev(duration,i)>0)?", ":"";
                String temp = (duration[i]==1)?duration[i]+" second":duration[i]+" seconds";
                format = format + prefix + temp;
              }
              break;
            }
          
        }
        if(count>1) format = format.substring(0,format.lastIndexOf(","))+" and"+ format.substring(format.lastIndexOf(",")+1,format.length());
      
        return format;
        
    }
    
    public static int countPrev(int[] arr,int index){
      int count = 0;
      for(int i = 0;i<index;i++){
        if(arr[i]!=0) count++;
      }
      return count;
    }
}