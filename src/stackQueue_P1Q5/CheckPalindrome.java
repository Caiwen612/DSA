package stackQueue_P1Q5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    /*
    Guideline
           in loop :
               if st.pop() != que.poll()
                   match = false
                   break;
           end loop
       */
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a set of string: ");
        String word = input.nextLine();

        if(isPalindrome(word)){
            System.out.println("This is palindrome word.");
        } else {
            System.out.println("This is not palindrome word.");
        }



    }

    public static boolean isPalindrome(String word){
        Stack<Character> letterStack = new Stack<>();
        Queue<Character> letterQueue = new LinkedList<>();

        //add letter into 2 data structure
        for(int i=0;i < word.length();i++){
            if(Character.isAlphabetic(word.charAt(i))){
                //convert it to lowercase
                char letter = Character.toLowerCase(word.charAt(i));
                letterStack.push(letter);
                letterQueue.add(letter);
            }
        }

        //pop letter
        while(!letterStack.empty()){
            //Assume input is Zhi Yi
            //Stack(LIFO) == Print the word in reverse sequence(Last In First Out)
            //push = Zhi Yi
            //pop = iY ihZ

            //Queue(FIFO) == Print the word in real sequence(First In First Out)
            //Enqueue == Zhi Yi
            //Dequeue == Zhi Yi

            if(!letterStack.pop().equals(letterQueue.poll())){
                return false;
            }
        }
        return true;
    }
}
