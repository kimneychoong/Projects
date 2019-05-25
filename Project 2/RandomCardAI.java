public class RandomCardAI implements AI {
    public Card getPlay(Hand hand, CardPile cardPile){
        int handLength = hand.jevi.length;
        for(int i=0; i < handLength; i++){
            if(cardPile.canPlay(hand.jevi[i])){
                return hand.jevi[i];
            }
        }
            return null;
    }
    public String toString(){
        return "Random Card AI";
    }
}
