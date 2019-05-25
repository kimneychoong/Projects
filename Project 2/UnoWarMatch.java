public class UnoWarMatch{
    private AI ai1;
    private AI ai2;


    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    public boolean playGame() {
        int winCount1=0;
        int winCount2=0;
        while(winCount1 != 10 && winCount2 !=10) {
            Deck AIdeck = new Deck();
            Hand ai1hand = new Hand(AIdeck, 5);
            Hand ai2hand = new Hand(AIdeck, 5);
            CardPile aicardpile = new CardPile(AIdeck.draw());
            while (true) {

                if (ai1.getPlay(ai1hand, aicardpile) != null) {
                    aicardpile.play(ai1.getPlay(ai1hand, aicardpile));
                    ai1hand.remove(ai1.getPlay(ai1hand, aicardpile));

                } else {

                    winCount2 += 1;
                    break;
                }
                if (ai2.getPlay(ai2hand, aicardpile) != null) {
                    aicardpile.play(ai2.getPlay(ai2hand, aicardpile));
                    ai2hand.remove(ai2.getPlay(ai2hand, aicardpile));

                } else {

                    winCount1 += 1;
                    break;
                }
            }
        }
        return (winCount1 > winCount2);
    }

    public double winRate(int nTrials){
        int count = 0;
       for (int i = 0; i < nTrials; i++)
        {
            if (playGame())
            {
                count += 1;
            }
        }

      double winrate = ((double)count/(double)nTrials);
        return winrate;
    }
}
