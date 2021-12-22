import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    protected Deck(){
        int count = 0;
        cards = new ArrayList<>();
        for(char i = 'a'; i < 101; i++){
            for(int x = 1; x < 14; x++) {
                cards.add(new Card(i, x));
                count++;
            }
        }

        if(count==52)
        System.out.print("\nDeck Created\n\n");
        else System.out.print("Bad Deck");

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.printf("Shuffle: %d\n", i);
                shuffle();

            }
        }catch(ExceptionInInitializerError ex){
            System.out.println("Error");
        }

    }

    /**
     * Shuffle method that guarantees RNG - previous method versions in comments
     */
    /*
    private void shuffle(){
        ArrayList<Card> one = new ArrayList<>();
        ArrayList<Card> two = new ArrayList<>();
        ArrayList<Card> post = new ArrayList<>();

        for (int i = 0,x = 26; i < 26; i++,x++) {
            one.add(cards.get(i));
            two.add(cards.get(x));
        }

        int flip = (int) (Math.random() * 2);
        // 0 0.1 0.2 0.3 0.4 0.5 0.6 0.7 0.8 0.9 || 1 1.1 1.2 1.3 1.4 1.5 1.6 1.7 1.8 1.9
        for (int i = 0; i < one.size(); i++) {
            if(flip==0) {
                post.add(one.get(i));
                post.add(two.get(i));
            }
            else{
                post.add(two.get(i));
                post.add(one.get(i));
            }
        }

       cards = post;

        cutDeck();

        printDeck(cards);

    }
     */
    private void shuffle() throws ExceptionInInitializerError{
        ArrayList<Card> temp = new ArrayList<>(cards);

        for (int i = 0; i < temp.size(); i++) {

            int pos = (int) (Math.random() * 52);
          //  System.out.print("pos = " + pos + " i = " + i +"\n");

            cards.add(pos,temp.get(i));
            cards.remove(i+1);

            if(isDistinct()) {
                System.out.print(isDistinct());
                throw new ExceptionInInitializerError();
            }
        }

        if(isFull())
            System.out.print("full \n");


        System.out.println(cards);
       // printDeck(cards);

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
