// Assignment 1 - Carter Giesbrecht - 3184975
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards;

    //constructor
    Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    //getters and setters
    public Card getCard(int index) {
        return cards.get(index);
    }

    public void setCard(int index, Card card) {
        cards.set(index, card);
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //play and remove card

    public void addCard(Card dealt) { // will probably need to fix
        cards.add(dealt);
    } //add card to deck

    public void playCard(int index) { //remove card from hand
        cards.remove(index);
    }

    public int handSize()
    {
        return cards.size();
    } //return size of hand

    public String toString() //print name and cards
    {
        String output = "(" + name + "'s hand: ";
        for(int i = 0; i < cards.size(); i++)
        {
            output += cards.get(i).toString();
            if( i!=cards.size()-1 )
            {
                output += ", ";
            }
        }
        output += ")";
        return output;
    }
}
