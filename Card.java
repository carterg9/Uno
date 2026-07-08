// Assignment 1 - Carter Giesbrecht - 3184975
public class Card { //Contains Colour and Face enums

    private Colour colour;
    private Face face;

    //constructors
    public Card (Colour colour, Face face) {
        this.colour = colour;
        this.face = face;
    }

    //getters and setting
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public boolean playable(Card lastCard)  //checks if card is playable
    {
        return this.colour == lastCard.getColour() || this.face == lastCard.getFace();
    }

    public String toString() // edit output for clarity
    {
        String faceStr;
        switch (face) {
            case ZERO: faceStr = "0"; break;
            case ONE: faceStr = "1"; break;
            case TWO: faceStr = "2"; break;
            case THREE: faceStr = "3"; break;
            case FOUR: faceStr = "4"; break;
            case FIVE: faceStr = "5"; break;
            case SIX: faceStr = "6"; break;
            case SEVEN: faceStr = "7"; break;
            case EIGHT: faceStr = "8"; break;
            case NINE: faceStr = "9"; break;
            case SKIP: faceStr = "Skip"; break;
            case REVERSE: faceStr = "Reverse"; break;
            default: faceStr = "*"; break; //in the case of wild there is no face
        }

        String colourStr;
        switch (colour) {
            case RED: colourStr = "Red"; break;
            case BLUE: colourStr = "Blue"; break;
            case GREEN: colourStr = "Green"; break;
            case YELLOW: colourStr = "Yellow"; break;
            default: colourStr = "Wild"; break;
        }
        return colourStr + " " +  faceStr;
    }
}
