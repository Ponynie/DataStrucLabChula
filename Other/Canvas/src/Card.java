public class Card {
    private String cardIden;

    public Card(int cardNum , String cardSym) {
        cardIden = cardSym + String.valueOf(cardNum);
    }
    public boolean equals(Object o) {
        if (o instanceof Card e) {
            return cardIden.equals(e.getName());
        }
        return false;
    }
    public String getName() {
        return cardIden;
    }
}
