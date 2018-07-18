public class GoogleFooBarLevelOne{

     public static void main(String []args){
        System.out.println(answer("abababababab"));
    
     }
     
    public static int answer(String s) { 
        int size = s.length();
        int max = 1;
        String cut = "";
        String first = "";
       int count = 0;
       
       for(int i = 1; i<=size;i++){
           if(size%i==0){
               boolean flag = true;
               int cutSize = size/i;
               for(int j = 1;j<=size;j++){
                   cut = cut + s.charAt(j-1);
                   if(j%cutSize == 0) {
                       if(count>0){
                           if(!cut.equals(first)) flag = false;
                       }else{
                           first = cut;
                       }
                       count++;
                       cut = "";
                   }
               }
                if(flag) max = count;
                count = 0;
           }
       }
       return max;
    }

}