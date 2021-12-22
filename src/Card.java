public class Card {
// get instance vars in check
    private final String code;

    private final int num;
    private  String numString;
    private final char suitChar;
    private Suit suit;

    public Card(char suitChar, int num){

        this.num = num;
        this.suitChar = suitChar;

        /*
         * Char to Enum transfer for ID
         */
        if(suitChar == 'a')
            suit = Suit.spades;
        if(suitChar == 'b')
            suit = Suit.hearts;
        if(suitChar == 'c')
            suit = Suit.clubs;
        if(suitChar == 'd')
            suit = Suit.diamonds;

        /*
         * char int to String ID
         */
        if(num == 1)
            numString = "Ace";
        else if(num == 2)
            numString = "Two";
        else if(num == 3)
            numString = "Three";
        else if(num == 4)
            numString = "Four";
        else if(num == 5)
            numString = "Five";
        else if(num == 6)
            numString = "Six";
        else if(num == 7)
            numString = "Seven";
        else if(num == 8)
            numString = "Eight";
        else if(num == 9)
            numString = "Nine";
        else if(num == 10)
            numString = "Ten";
        else if(num == 11)
            numString = "Jack";
        else if(num == 12)
            numString = "Queen";
        else if(num == 13)
            numString = "King";


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