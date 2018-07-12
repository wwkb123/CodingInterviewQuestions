/*

You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
NOTE: All numbers will be whole numbers greater than 0.

*/

public class ExpandedForm
{
    public static String expandedForm(int num)
    {
      
      String numStr = num + "";
      String c = numStr.charAt(0) + "";
      String result = Integer.parseInt(c)*((int)Math.pow(10,numStr.length()-1)) + "";
        for(int i = numStr.length()-2,j = 1;i>=0;i--,j++){
          c = numStr.charAt(j) + "";
          if(!c.equals("0")){
            result = result + " + " + Integer.parseInt(c)*((int)Math.pow(10,i));
          }
      }
      return result;
    }
}