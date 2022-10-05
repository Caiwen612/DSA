package list_P1Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 @author sir
 @DSA list & arrayList
 @Status done
 */

public class ScoreApp {
    private List<Integer> scoreList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private int MAXIMUM_SCORE = 100;

    public void inputScores(){
        int nextScore = -1;
        int i = 1;
        do{
            System.out.print("Enter score #" + i + ": ");
            nextScore = input.nextInt();
            if(nextScore > MAXIMUM_SCORE) {
                System.out.println("The maximum test score is " + MAXIMUM_SCORE);
            } else if(nextScore > 0){
                scoreList.add(nextScore);
                i++;
            }
        } while(nextScore >= 0);

        System.out.println("Input test scores completed\n");
    }

    public void displayScores(){
        for (int score:scoreList) {
            System.out.println(score);
        }
    }

    public int findLowest(){
        int lowest = scoreList.get(0);
        for (int score:scoreList) {
            if(score < lowest){
                lowest = score;
            }
        }
        return lowest;
    }

    public int findHighest(){
        int highest = scoreList.get(0);
        for (int score:scoreList) {
            if(score > highest){
                highest = score;
            }
        }
        return highest;
    }

    public double computeAverage(){
        int total = 0;
        for (int score:scoreList) {
            total += score;
        }
        return (double) total / scoreList.size();
    }

    public void displayStatistics(){
        System.out.println("Statistic");
        System.out.println("---------");
        System.out.println("Lowest score: " + findLowest());
        System.out.print("Highest score: " + findHighest());
        System.out.print("\nAverage score: " + computeAverage());
    }

    public static void main(String [] args){
        ScoreApp app = new ScoreApp();
        app.inputScores();
        app.displayScores();
        app.displayStatistics();
    }


}


