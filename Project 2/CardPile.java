public class CardPile {
    private int cardPileNumber;

    public class Node {
        public Card cardValue;
        public Node nextCard;

        public Node(Card cardValue, Node nextCard) {
            this.cardValue = cardValue;
            this.nextCard = nextCard;
        }
    }

    public Node top;

    public CardPile(Card topCard) {
        cardPileNumber = 1;
        top = new Node(topCard, null);
    }

    public boolean canPlay(Card card) {
        if (card == null) {
            throw new IllegalArgumentException();
        }
        return (card.getRankNum() >= top.cardValue.getRankNum() || card.getSuitName() == top.cardValue.getSuitName());
    }

    public void play(Card card) {
        if (!canPlay(card)) {
            throw new IllegalArgumentException();
        } else {
            top = new Node(card, this.top);
            cardPileNumber++;
        }
    }

    public int getNumCards() {
        return cardPileNumber;
    }

    public Card getTopCard() {
        return top.cardValue;
    }


}