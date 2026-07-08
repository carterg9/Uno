// Assignment 1 - Carter Giesbrecht - 3184975
import java.util.Random;

public class GamePlay {
    private CircularDoublyLinkedList<Player> players;
    private Deck deck;
    private Card lastCard;
    private boolean done;   //check if game is done

    //constructor (get game ready to play
    public GamePlay(Player p1, Player p2, Player p3,  Player p4) {
        this.deck = new Deck();
        deck.buildCards();
        deck.shuffle();

        this.players = new CircularDoublyLinkedList<Player>();

        //add players
        players.addLast(p1);
        players.addLast(p2);
        players.addLast(p3);
        players.addLast(p4);

        //make all players hands
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < players.size(); j++)
            {
                Player current = players.first();
                current.addCard(deck.deal());
                players.rotate();
            }
        }

        //print hands
        System.out.println("PLayers and hands:");
        for(int i = 0; i < players.size(); i++)
        {
            System.out.println(players.first().toString());
            players.rotate();
        }

        this.lastCard = deck.deal();
        if(this.lastCard.getColour() == Colour.BLACK) //if card is wild, redeal first card
        {
            this.lastCard = deck.deal();
        }

        //print first card and begin game
        System.out.println('\n' + "first card " + lastCard.toString());

        turn(); //begin
    }

    public void turn()
    {
        while(!done) { //while game is not done, loop through
            System.out.println(players.first().toString());


            lastCard = playGame(players, lastCard, deck);

            if(players.first().handSize() == 0) //if player has no cards left, end game
            {
                done = true;
                System.out.println(players.first().getName() + " wins!");
                System.out.println("Total cards remaining in deck: " + deck.size());
            }

            System.out.println();
            players.rotate(); //rotate to next player
        }
    }

    //getters and setters
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Card getLastCard() {
        return lastCard;
    }

    public void setLastCard(Card lastCard) {
        this.lastCard = lastCard;
    }


    public Card playGame(CircularDoublyLinkedList<Player> players, Card lastCard, Deck deck) //play a round of uno
    {
        boolean found = false; //check if found is true
        for(int i = 0; i< players.first().handSize(); i++) //loop through players hand
        {
            //check if card is playable, or if wild is in play/playable
            if(players.first().getCard(i).playable(lastCard) || players.first().getCard(i).getColour() == Colour.BLACK || lastCard.getColour() == Colour.BLACK)
            {
                found = true; //set found to true
                //print for user
                System.out.println(players.first().getName() + " plays " + players.first().getCard(i).toString());

                //if the card is reverse, reverse the order
                if(players.first().getCard(i).getFace() == Face.REVERSE)
                {
                    System.out.println("Game reverses direction!");
                    players.reverse();
                }

                //if the card played is wild, call wild function
                if(players.first().getCard(i).getColour() == Colour.BLACK)
                {
                    players.first().setCard(i, wildCard(players.first().getCard(i)));
                }

                //set new lastCard, and remove from players hand
                lastCard = players.first().getCard(i);
                players.first().playCard(i);

                //check if user needs to say UNO!
                if(players.first().handSize() == 1)
                {
                    System.out.println(players.first().getName() + " yells UNO!");
                }

                //if card was skip, skip next players turn
                if(lastCard.getFace() == Face.SKIP)
                {
                    players.rotate();
                    System.out.println(players.first().getName() + " misses a turn");
                }

                return lastCard;
            }
        }
        if (!found){ // if card was not found, user must draw
        System.out.print(players.first().getName() + " has no play, ");
    }
        //deal and print
        Card drawn = deck.deal();
        System.out.println(players.first().getName() + " draws " + drawn.toString());

        //check if this card can be played or if its wild
        if(drawn.playable(lastCard) || drawn.getColour() == Colour.BLACK)
        {
            System.out.println(players.first().getName() + " plays " + drawn.toString());

            //if the card is reverse, reverse the order
            if(drawn.getFace() == Face.REVERSE)
            {
                System.out.println("Game reverses direction!");
                players.reverse();
            }

            //if the card is wild, call wild function
            if(drawn.getColour() == Colour.BLACK)
            {
                drawn = wildCard(drawn);
            }

            lastCard = drawn;
            //see if user needs to yell UNO!
            if(players.first().handSize() == 1)
            {
                System.out.println(players.first().getName() + " yells UNO!");
            }

            return lastCard;
        }
        //player cant play the drawn card, so its adds it to hand
        System.out.println("cant play it");
        players.first().addCard(drawn);
        return lastCard;
    }

    public Card wildCard(Card card)
    {
        System.out.print("Colour is now ");

        //randomly assign the next colour
        Random rand = new Random();
        int num = rand.nextInt(4);
        switch(num){
            case 0: card.setColour(Colour.RED);
                System.out.println(card.getColour().toString()); break;
            case 1: card.setColour(Colour.BLUE);
                System.out.println(card.getColour().toString()); break;
            case 2: card.setColour(Colour.GREEN);
                System.out.println(card.getColour().toString()); break;
            case 3: card.setColour(Colour.YELLOW);
                System.out.println(card.getColour().toString()); break;
        }
        return card;
    }
}
