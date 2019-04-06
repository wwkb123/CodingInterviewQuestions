class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens){
            if(!isSymbol(token)){   // is a number
                int num = Integer.parseInt(token);
                stack.push(num);
            }else{                  // is a operator
                char c = token.charAt(0);
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(c){
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    
    public boolean isSymbol(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
