public class BiggestCardAI implements AI{
    public Card getPlay(Hand hand, CardPile cardPile) {
        int topRank = cardPile.top.cardValue.rank;
        for (int x = 13; x >= topRank; x--) {
            for (int i = 0; i < hand.jevi.length; i++) {
                if (hand.jevi[i].rank == x) {
                    return hand.jevi[i];
                }
            }
        }
        return null;
    }
    public String toString(){
        return "Biggest Card AI";
    }
}

