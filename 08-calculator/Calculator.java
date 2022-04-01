import java.util.ArrayDeque;
import java.util.Scanner;
public class Calculator {
    /** 
     * Evaluate a postfix expression stored in s.
     * Assume valid postfix notation, of ints doubles and operators separated by
     * spaces.
     * Valid operators are + - / * and % (remainder not modulo)
     * All results are doubles even if the operands are both int.
     * 
     * @throws IllegalArgumentException when there are too many or too few operands.
     * Use the string parameter of your exception to indicate what happened.
     * Either "too many operands" or "too few operands for operation _" replace _
     * with +,- etc.
     */
    
        public static double eval(String s) {
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        String[] stuff = s.split(" "); 
        for(String token : stuff) {
            char op = token.charAt(0);
            if(isOperator(op)) {
                if (stack.size() < 2) throw new IllegalArgumentException("Too many operators");
                double second = stack.pop();
                double first = stack.pop(); 
                switch(op) {
                    case '*' :  stack.push(first * second);
                                break;
                    case '/' :  stack.push(first / second);
                                break;
                    case '-' :  stack.push(first - second);
                                break;
                    case '+' :  stack.push(first + second);
                                break;
                }
            }
            else {
                stack.push(Double.parseDouble(token));
            }
        }
        if (stack.size() > 1) throw new IllegalArgumentException("Too many operands"); 
        return stack.getFirst(); 
        }



    public static void main(String[] args) {
        String[] ktest = { "11 3 - 4 + 2.5 *", "10 2.0 +", "8 2 + 99 9 - * 2 + 9 -", "1 2 3 4 5 + * - -" }; 
        for(String s : ktest ) {
            System.out.println(s); 
            System.out.println(eval(s)); 
        }
        System.out.println("Exception Testing"); 
        eval("1 1 - - -"); 
        eval ("1 + 3"); 
        eval ("1 1 1 -"); 

    }

    private static boolean isOperator(char a) {
        return (a == '*') || (a == '/') || (a == '+') || (a == '-');
    }
}

