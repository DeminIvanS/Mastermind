package org.example.game;

import java.util.Random;

public class NumberForGuess {
    private static Random random = new Random();
    private static int numberForGuess;
    public NumberForGuess(int numberForGuess) {
        this.numberForGuess = numberForGuess;
    }

    public static int getNumberForGuess() {
        return numberForGuess;
    }
    protected static NumberForGuess generatedNumber(){
        StringBuilder sb = new StringBuilder();
        int counter = 4;

        while (true) {
            int num = random.nextInt(10);
            if(!sb.toString().contains(Integer.toString(num)) && num > 0){
                sb.append(num);
                counter--;
            }
            if(counter == 0){
                break;
            }
        }
        numberForGuess = Integer.parseInt(sb.toString());
        return new NumberForGuess(numberForGuess);
    }
}
