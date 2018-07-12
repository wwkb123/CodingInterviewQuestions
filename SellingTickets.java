/*

The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. 
Each of them has a single 100, 50 or 25 dollars bill. An "Avengers" ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to each person and give the change if he initially has no money and sells the tickets strictly in the order people follow in the line?

Return YES, if Vasya can sell a ticket to each person and give the change with the bills he has at hand at that moment. Otherwise return NO.

###Examples:

// *** Java ***

Line.Tickets(new int[] {25, 25, 50}) // => YES 
Line.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change 
(you can't make two bills of 25 from one of 50)


*/
public class SellingTickets {
  public static String Tickets(int[] peopleInLine)
  {
        if(peopleInLine[0]!=25){
          return "NO";
        }
        int num_25 = 1;
        int num_50 = 0;
        for(int i=1;i<peopleInLine.length;i++){
          int bill = peopleInLine[i];
          switch(bill){
            case 25:
              num_25++;
              break;
            case 50:
              if(num_25>0){
                num_25--;
                num_50++;
              }else{
                return "NO";
              }
              break;
            case 100:
              if(num_25>0 && num_50>0){
                num_25--;
                num_50--;
              }else if(num_25>2){
                num_25 -= 3;
              }else{
                return "NO";
              }
              break; 
          }
        }  
        return "YES";
  }
          
      
}