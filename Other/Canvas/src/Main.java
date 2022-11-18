import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck(50);
        for (int i = 0; i < 25 ; i ++) {
            deck.addCard(new Card(i+1,"+"));
        }
        for (int i = 0; i < 25 ; i ++) {
            deck.addCard(new Card(i+1,"-"));
        }
        deck.viewDeck();
        System.out.println("\n----------------------------------------------------------------");
        System.out.println(deck.draw().getName());
        System.out.println("\n----------------------------------------------------------------");
        deck.viewDeck();
    }
}
