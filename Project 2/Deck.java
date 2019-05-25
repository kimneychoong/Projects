import java.util.Random;
public class Deck {
    private Card[] Deck = new Card[52];
    private int numOfCard = 52;

    public Deck() {
        int index = 0;
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                Deck[index] = new Card(i, j);
                index++;
            }
        }
        shuffle();

    }

    public void shuffle() {
        Random card = new Random();
        numOfCard = 52;
        for (int i = Deck.length - 1; i >= 1; i--) {
            int j = card.nextInt(52);
            Card temp = Deck[j];
            Deck[j] = Deck[i];
            Deck[i] = temp;
        }
    }

    public Card draw() {
        if (isEmpty()) {
            shuffle();
            numOfCard -= 1;
            return Deck[numOfCard];
        }
        numOfCard -= 1;
        return Deck[numOfCard];
    }

    public int cardsRemaining() {
        return numOfCard;
    }

    public boolean isEmpty() {
        return numOfCard == 0;
    }

}