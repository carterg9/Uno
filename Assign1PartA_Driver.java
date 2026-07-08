// Assignment 1 - Carter Giesbrecht - 3184975
import java.util.ArrayList;
import java.util.Scanner;

public class Assign1PartA_Driver {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in); // scanner

        System.out.println("Let's play UNO!!!" + '\n');
        // Assign all players names
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Create Players!"); //get user to input character names
        for(int i = 0; i< 4; i++) {
            System.out.print("Player #" + (i+1) + "'s name: ");
            String name = kb.nextLine();
            players.add(new Player(name));
        }
        System.out.println(""); //create a blank line
        //start game
        GamePlay gp = new GamePlay(players.get(0),  players.get(1), players.get(2), players.get(3)); //set all players into the game
    }
}

