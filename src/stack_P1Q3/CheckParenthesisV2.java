package stack_P1Q3;

import java.util.Scanner;
import java.util.Stack;

public class CheckParenthesisV2 {
    private static Stack<Character> stOperator = new Stack();
    /*
               in loop :
                   extract 1 char from the expression
                   if the char is [, {, (, < --> push to stack
                   if the char is ],},),>
                       check if 1st member in stack is the right partner
                           if yes - pop stack
                           if not - don't do anything
               end loop

               if stack is empty, return true.
               else return false
     */
    public static boolean validateExpression(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '[':
                case '{':
                case '(':
                    stOperator.push(expression.charAt(i));
                    break;
                case ']':
                    if (stOperator.peek().equals('['))
                        stOperator.pop();
                    break;
                case '}':
                    if (stOperator.peek().equals('{'))
                        stOperator.pop();
                    break;
                case ')':
                    if (stOperator.peek().equals('('))
                        stOperator.pop();
                    break;
            }
        }

        if (stOperator.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        String userTxt;

        System.out.print("Enter mathematical expression:  ");
        userTxt = new Scanner(System.in).nextLine();

        System.out.print("The expression is ");
        System.out.println(validateExpression(userTxt) ? "valid." : "invalid.");
    }
}
