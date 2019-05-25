public class Hand {
    private int size;
    private Deck deck;
    public Card[] jevi;

    public Hand(Deck deck, int size) {
        this.size = size;
        this.deck = deck;
        jevi = new Card[size];
        for (int i = 0; i < size; i++) {
            jevi[i] = deck.draw();
        }
    }

    public int getSize() {
        return size;
    }

    public Card get(int i) {
        if (i >= size || i < 0) {
            throw new IllegalArgumentException();
        }
        return jevi[i];
    }

    public boolean remove(Card card) {
        for (int i = 0; i < jevi.length; i++) {
            if (card.equals(jevi[i])) {
                jevi[i] = deck.draw();
                return true;
            }
        }
        return false;
    }
}