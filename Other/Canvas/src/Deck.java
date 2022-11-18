import java.util.Random;

public class Deck {
    private Card[] deck;
    private int size;

    public Deck(int cap) {
        deck = new Card[cap];
        size = 0;
    }
    public Deck() {
        deck = new Card[53];
        size = 0;
    }
    private void removeCard(Card c) {
        for (int i = 0; i < size; i++) {
            if (c.equals(deck[i])) {
                deck[i] = deck[--size];
                deck[size] = null;
            }
        }
    }   
    public Card draw() {
        if (size < 1) throw new UnsupportedOperationException("No card to draw");
        Random rand = new Random();
        Card c = deck[rand.nextInt(size)];
        removeCard(c);
        return c;
    }
    public void addCard(Card c) {
        if (size == deck.length) throw new IndexOutOfBoundsException("Deck is full");
        for (int i = 0; i < size; i++) {
            if (c.equals(deck[i])) throw new IllegalArgumentException("Duplicate card");
        }
        deck[size++] = c;
    }
    public void viewDeck() {
        for (int i = 0; i < size; i++) {
            System.out.print(" " + deck[i].getName());
        }
    }
} 
