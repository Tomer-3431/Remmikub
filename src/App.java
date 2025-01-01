public class App {
    public static void main(String[] args) throws Exception {
        Card[] x = new Card[] {new Card(), new Card(2, Card.CARD_COLOR.BLUE), new Card(3, Card.CARD_COLOR.BLUE), new Card()};
        new Seria(x);
    }
}
