package org.example.game;

public class Game {
    private static String forMatching;
    private static int totalTry = 10;

    public static void start(){
                NumberForGuess.generatedNumber();
                totalTry = 10;
    }

    public static void isMatches(String enteredNumber) {

        forMatching = String.valueOf(NumberForGuess.getNumberForGuess());
        if(totalTry > 1) {
            if (forMatching.equals(enteredNumber)) {
                printYouWinner();
                printPlayAgain();
            } else {
                if (forMatching.length() == enteredNumber.length()) {
                    totalTry--;
                    int countBull = getBulls(enteredNumber);
                    int countCows = getCows(enteredNumber);
                    printCountItems(countBull, countCows);
                    printTotalTry();
                } else {
                    printLengthEnough();
                }
            }
        }else {
            printYouLose();
            printPlayAgain();
        }
    }
    private static int getBulls(String num){
        int count=0;
        char[] numGenerated = forMatching.toCharArray();
        char[] numEntered = num.toCharArray();
        for (int i = 0; i < numEntered.length; i++) {
            if(numEntered[i]==numGenerated[i]){
                count++;
                numGenerated[i] = '*';
            }
        }
        forMatching = String.copyValueOf(numGenerated);
        return count;
    }
    private static int getCows(String num){
        int count=0;
        char[] numGenerated = forMatching.toCharArray();
        char[] numEntered = num.toCharArray();
        for (int i = 0; i < numEntered.length; i++) {
            for (int j = 0; j < numGenerated.length; j++) {
                if(numEntered[i] == numGenerated[j] && i!=j){
                    numGenerated[j] = '*';
                    count++;
                    break;
                }
            }
        }

        return count;
    }
    public static void printTotalTry(){
        System.out.println("You have " + totalTry + " tries left");
    }
    private static void printYouLose(){
        System.out.println("You lose.");
    }
    private static void printPlayAgain(){
        System.out.println("Shall we play again?");
    }
    private static void printYouWinner(){
        System.out.println("You Winner!");
    }
    private static void printLengthEnough(){
        System.out.println("Please enter a number, four digits long");
    }
    private static void printCountItems(int bulls, int cows){
        System.out.println("Count of bulls " + bulls + ", count of cows " + cows);
    }
}
