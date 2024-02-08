package org.example.game;

public class Parser {

    public void parser(String item) {
        if (item.isEmpty()) {
            System.out.println("You did not enter anything, try again.");
        } else if (isInteger(item)) {
            Game.isMatches(item);
        }else{
            System.out.println("Is not digit, please enter number.");
        }
    }
    private boolean isInteger (String item){
        try{
            Integer.parseInt(item);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
