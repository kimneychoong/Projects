public class Card {
    public int rank;
    public int suit;
    private String[] RankName = new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String[] SuitName = new String[]{"Spades", "Hearts", "Clubs", "Diamonds"};

    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            throw new IllegalArgumentException();
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    public int getRankNum() {
        return rank;
    }

    public String getRankName() {
        return RankName[rank - 1];
    }

    public String getSuitName() {
        return SuitName[suit - 1];
    }

    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card cObj = (Card) obj;
            if (rank == cObj.rank && suit == cObj.suit) {
                return true;
            }
        }
        return false;
    }
}