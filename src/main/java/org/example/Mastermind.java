package org.example;

import org.example.game.Game;
import org.example.game.Parser;

import java.util.Scanner;

public class Mastermind {
    private static Game game;
    public static void main(String[] args) {
        Parser parser = new Parser();
        game = new Game();
        game.start();

        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.println("Enter \"exit\" for closed application");
        System.out.println("For start new game, please enter \"new\".");
        game.printTotalTry();
        while (true) {
            str = scanner.nextLine();
            if (str.toLowerCase().equals("exit")){
                System.out.println("Application is closed.");
                scanner.close();
                System.exit(0);
            }else if(str.toLowerCase().equals("new") || str.toLowerCase().equals("yes")){
                game.start();
                game.printTotalTry();
            }else{
                parser.parser(str);
            }
        }
    }
}