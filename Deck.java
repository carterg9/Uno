// Assignment 1 - Carter Giesbrecht - 3184975
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    //constructors
    public Deck() {
        cards = new ArrayList<>();
    }

    public void buildCards() {

        Face[] faces = {
                Face.ZERO, Face.ONE, Face.TWO, Face.THREE, Face.FOUR,
                Face.FIVE, Face.SIX, Face.SEVEN, Face.EIGHT,
                Face.NINE, Face.SKIP, Face.REVERSE
        };

        Colour[] colours = {
                Colour.RED, Colour.BLUE, Colour.YELLOW, Colour.GREEN
        };

        // Add 2 of each face per colour
        for (int i = 0; i < colours.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                cards.add(new Card(colours[i], faces[j]));
                cards.add(new Card(colours[i], faces[j]));
            }
        }
        // Add 4 wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(Colour.BLACK, Face.WILD));
        }
    }

    //shuffle cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() //deal and remove card from deck
    {
        Card temp = cards.get(0);
        cards.removeFirst();
        return temp;
    }

    public int size() { //return size
        return cards.size();
    }

    public String toString() {  //loop through entire deck (for testing purposes)
        String result = "";

        for (int i = 0; i < cards.size(); i++) {
            result += cards.get(i).toString() + "\n";
        }
        return result;
    }
}

