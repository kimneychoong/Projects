public class SmallestCardAI implements AI
{
    private Card[] newArray;
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        int elements = 0;
        Card card1;
        newArray = new Card[hand.jevi.length];
        int i = 0;
        while (i < hand.jevi.length)
        {
            if (cardPile.canPlay(hand.jevi[i]))
            {
                newArray[elements] = hand.jevi[i];
                elements++;
            }
            i++;
        }
        if (elements > 0)
        {
            card1 = newArray[0];
            i = 0;
            while (i < elements) {
                if (newArray[i].rank < card1.rank) {
                    card1 = newArray[i];
                }
                i++;
            }
        }
        else {
            return null;
        }
        return card1;
    }

    public String toString()
    {
        return "Smallest Card AI";
    }
}
