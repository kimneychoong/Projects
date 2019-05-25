public class Tournament {
    public static void main(String[] args) {
      AI rc = new RandomCardAI();
      AI bc = new BiggestCardAI();
      AI sc = new SmallestCardAI();
      UnoWarMatch test1 = new UnoWarMatch(rc,rc);
      UnoWarMatch test2 = new UnoWarMatch(rc,sc);
      UnoWarMatch test3 = new UnoWarMatch(rc,bc);
      UnoWarMatch test4 = new UnoWarMatch(sc,rc);
      UnoWarMatch test5 = new UnoWarMatch(sc,sc);
      UnoWarMatch test6 = new UnoWarMatch(sc,bc);
      UnoWarMatch test7 = new UnoWarMatch(bc,rc);
      UnoWarMatch test8 = new UnoWarMatch(bc,sc);
      UnoWarMatch test9 = new UnoWarMatch(bc,bc);
      System.out.println("Random Card AI vs. Random Card AI winRate "+test1.winRate(1000));
      System.out.println("Random Card AI vs. Smallest Card AI winRate "+test2.winRate(1000));
      System.out.println("Random Card AI vs. Biggest Card AI winRate "+test3.winRate(1000));
      System.out.println("Smallest Card AI vs. Random Card AI winRate "+test4.winRate(1000));
      System.out.println("Smallest Card AI vs. Smallest Card AI winRate "+test5.winRate(1000));
      System.out.println("Smallest Card AI vs. Biggest Card AI winRate "+test6.winRate(1000));
      System.out.println("Biggest Card AI vs. Random Card AI winRate "+test7.winRate(1000));
      System.out.println("Biggest Card AI vs. Smallest Card AI winRate "+test8.winRate(1000));
      System.out.println("Biggest Card AI vs. Biggest Card AI winRate "+test9.winRate(1000));


    }
}
