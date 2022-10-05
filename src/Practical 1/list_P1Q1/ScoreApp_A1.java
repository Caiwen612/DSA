package list_P1Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 @author cw
 @version 1.0
 @duration 45 minutes
 @DSA list & arrayList
 @Status Done
*/

public class ScoreApp_A1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Create a list
        List<Integer> studentScore = new ArrayList<Integer>();
        studentScore.add(10);//index 0
        studentScore.add(20);//index 1

        int option = 0;
        while (true){
            menu();
            option = input.nextInt();
            switch (option){
                case 1://add score
                    int score;
                    System.out.print("Enter score #" + (studentScore.size()+1) + ": ");
                    score = input.nextInt();
                    studentScore.add(score);
                    break;
                case 2://display total score
                    System.out.println("Score of student");
                    for(Integer result: studentScore){
                        System.out.println(result);
                    }
                    break;
                case 3://display lowest score
                    int lowestScore = studentScore.get(0);
                    for(Integer result: studentScore){
                        if (result < lowestScore){
                            lowestScore = result;
                        }
                    }
                    System.out.println("Lowest Score: " + lowestScore);
                    break;
                case 4://display the highest score
                    int highestScore = studentScore.get(0);
                    for(Integer result: studentScore){
                        if (result > highestScore){
                            highestScore = result;
                        }
                    }
                    System.out.println("Highest Score: " + highestScore);
                    break;
                case 5://display average score
                    int total = 0;
                    int index = 0;
                    double average;
                    for(Integer result: studentScore){
                        total += result;
                        index += 1;
                    }
                    average = (double)(total/index);
                    System.out.println("Average score: " + average);
                    break;
                case 6://end program
                    System.exit(0);
                    break;
            }
            System.out.println("Press any key to continue.");
            input.nextLine();
            input.nextLine();
            clearScreen();
        }
    }

    public static void menu(){
        System.out.println("List application of score management");
        System.out.println("[1] Add score");
        System.out.println("[2] Display all score");
        System.out.println("[3] Display lowest score");
        System.out.println("[4] Display highest score");
        System.out.println("[5] Display average score");
        System.out.println("[6] End program");

        System.out.print("Enter your option: ");
    }

    public static void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

}
