public class Card {
    public enum CARD_COLOR {
        RED,
        YELLOW,
        GREEN,
        BLUE,
        JOKER
    }

    public int num;
    public CARD_COLOR color;

    public Card(int num, CARD_COLOR color) {
        this.num = num;
        this.color = color;
    }

    public Card() {
        num = 0;
        color = CARD_COLOR.JOKER;
    }

    @Override
    public String toString() {
        return color != CARD_COLOR.JOKER ? num + color.toString() : color.toString();
    }
}
