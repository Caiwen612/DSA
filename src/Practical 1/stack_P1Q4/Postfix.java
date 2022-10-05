package stack_P1Q4;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    private static Scanner input = new Scanner(System.in);
    private static Stack<Double> tempStack = new Stack<Double>();
    private static DecimalFormat df2 = new DecimalFormat("0.00");
    //Guideline
    /*
        loop:
            1) if character is number , push to stack
            if character is operator (+, *, -, /, %)
                r = pop as right operand
                l = pop as left operand
                // 2 - 1 == 21-
                //push sequence: 2(L),1(r)
                //pop sequence: 1(r),2(L)
                push (solution : l operator r)
        end loop
    */
    public static void main(String[] args) {
        System.out.print("Enter postfix expression: ");
        String text = input.nextLine();

        System.out.println("Your answers is " + df2.format(calculateResult(text)));
    }

    public static double calculateResult(String expression){
        for(int i = 0;i < expression.length();i++){
            char ch = expression.charAt(i);

            System.out.println("Current character is " + ch);

            if(Character.isDigit(ch)){
                tempStack.push((double) Character.getNumericValue(ch));
                System.out.println(ch + " has been add to the stack.");
            } else{
                    //Define operand variable
                    double r = tempStack.pop();
                    double l = tempStack.pop();
                    // 2 - 1 == 21-
                    //push sequence: 2(L),1(r)
                    //pop sequence: 1(r),2(L)
                    System.out.println("Left operand is " + l + " ," + "Right Operand is " + r);

                switch (ch){
                    case '+':
                        System.out.println("Perform operation " + l + " + " + r +  "= " + (l+r));
                        tempStack.push(l + r);
                         break;
                    case '-':
                        System.out.println("Perform operation " + l + " - " + r +  "= " + (l-r));
                        tempStack.push(l - r);
                        break;
                    case '*':
                        System.out.println("Perform operation " + l + " * " + r +  "= " + (l*r));
                        tempStack.push(l * r);
                        break;
                    case '/':
                        System.out.println("Perform operation " + l + " / " + r +  "= " + (l/r));
                        tempStack.push(l / r);
                        break;
                    case '%':
                        System.out.println("Perform operation " + l + " - " + r +  "= " + (l%r));
                        tempStack.push(l % r);
                        break;
                }
            }
        }

        return tempStack.pop();

    }


}
