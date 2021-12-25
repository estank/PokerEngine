import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    protected Deck(){
        int count = 0;
        //test this

        cards = new ArrayList<>(52);

        for(char i = 'a'; i < 101; i++){
            for(int x = 1; x < 14; x++) {
                cards.add(new Card(i, x));
                count++;
            }
        }

        System.out.println("\nDeck Created\n");

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.printf("Shuffle: %d\n", i);
                shuffle();
                printDeck(cards);

            }
        }catch(ExceptionInInitializerError ex){
            System.out.println("Error");
        }

    }
    /**
     * Shuffle method that guarantees RNG - previous method versions in comments
     */
    private void shuffle() throws ExceptionInInitializerError{
        ArrayList<Card> temp = new ArrayList<>(cards);
        int templength = temp.size();
        System.out.println(cards.size());
        for (int i = 0; i < temp.size(); i++) {

            int pos = (int) (Math.random() * templength);

            cards.add(pos,temp.get(i));
            System.out.println(cards.get(pos));
            cards.remove(i+1);
            temp.remove(pos);
            templength--;

        }
        printDeck(cards);

        if(!isDistinct()) {
            System.out.print(isDistinct());
            throw new ExceptionInInitializerError();
        }

        if(isFull())
            System.out.print("full \n");

    }
    public boolean isDistinct(){

        for (Card a: cards) {
            for(Card b: cards){
                if(a.equals(b))
                    return false;
            }
        }
        return true;
    }

    public boolean isFull(){
        return cards.size() == 52;
    }
    public void cutDeck(){
        ArrayList<Card> one = new ArrayList<>();
        ArrayList<Card> two = new ArrayList<>();
        ArrayList<Card> post = new ArrayList<>();

        for (int i = 0,x = 26; i < 26; i++,x++) {
            one.add(cards.get(i));
            two.add(cards.get(x));
        }

            post.addAll(two);
            post.addAll(one);

            cards = post;
    }

    @Override
    public String toString() {
        String fin = null;
        for (Card a: cards) {
            fin += String.format("%s",a);
        }

        return fin;
    }

    private void printDeck(ArrayList<Card> deck){
        //System.out.print(cards.forEach());
        for (Card a:deck) {
            System.out.print(a);
        }
        System.out.print("\n");
    }
}
