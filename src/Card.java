public class Card {
// get instance vars in check
    private final String code;

    private final int num;
    private  String numString;
    private Suit suit;

    public Card(char suitChar, int num){

        this.num = num;

        /*
         * Char to Enum transfer for ID
         */
        switch (suitChar) {
            case 'a' -> suit = Suit.spades;
            case 'b' -> suit = Suit.hearts;
            case 'c' -> suit = Suit.clubs;
            case 'd' -> suit = Suit.diamonds;
        }

        /*
         * char int to String ID
         */
        switch (num) {
            case 1 -> numString = "Ace";
            case 2 -> numString = "Two";
            case 3 -> numString = "Three";
            case 4 -> numString = "Four";
            case 5 -> numString = "Five";
            case 6 -> numString = "Six";
            case 7 -> numString = "Seven";
            case 8 -> numString = "Eight";
            case 9 -> numString = "Nine";
            case 10 -> numString = "Ten";
            case 11 -> numString = "Jack";
            case 12 -> numString = "Queen";
            case 13 -> numString = "King";
        }


        //ID code * may be stupid
        code = num + "" + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (this.num == ((Card) o).getNum()) return true;

        return true;
    }

    public String getCode(){ return code; }

    public int getNum() { return num; }

    public Suit getSuit() { return suit; }

    @Override
    public String toString() {
        return String.format("%s of %s\n",numString,suit) ;
    }

}