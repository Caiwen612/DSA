package stack_P1Q3;

import java.util.Scanner;
import java.util.Stack;

public class CheckParenthesis {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter mathematical expression: ");
        String expr = input.nextLine();

        if (checkBalance(expr)) {
            System.out.println("The mathematical expression has balanced. ");
        } else {
            System.out.println("The mathematical expression has not balanced. ");
        }
    }

    public static boolean checkBalance(String expr) {
        Stack<Character> bracketStack = new Stack<>();
        boolean match = true;
        for (int i = 0; i < expr.length() && match; i++) {
            char ch = expr.charAt(i);
            System.out.println("character #" + i + "= " + ch);
            //Find the target character and add in stack.
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    bracketStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (bracketStack.empty()) {
                        return false;
                    } else {
                        char leftBracket = bracketStack.pop();

                        switch (ch) {
                            case '}':
                                //match = leftBracket == '{';
                                if (leftBracket == '{') {
                                    return true;
                                }
                                break;
                            case ']':
                                match = leftBracket == '[';
                                break;
                            case ')':
                                match = leftBracket == '(';
                                break;
                        }
                    }
            }
        }

        if (!match || !bracketStack.empty()) {
            return false;
        } else {
            return true;
        }
    }
}


