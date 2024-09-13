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
    public boolean isJoker = false;
    public String name;

    public Card(int num, CARD_COLOR color) {
        this.num = num;
        this.color = color;
        
        name = String.valueOf(num) + color.toString().charAt(0);
    }

    public Card() {
        num = 0;
        color = CARD_COLOR.JOKER;
        isJoker = true;
    }

    public Card(String name) throws IllegalArgumentException {
        
        if (name.length() != 3 && name.length() != 2) {
            throw (new IllegalArgumentException("illegal name: wrong length"));
        }

        this.name = name.toUpperCase();

        if (name.toUpperCase().length() == 3) {
            if (name.toUpperCase().charAt(2) == 'J') {
                isJoker = true;
            }
        }

        try {
            num = ((int)name.charAt(0));
        } catch (ClassCastException e) {
            throw (new IllegalArgumentException("illegal name: num"));
        }

        switch (name.toUpperCase().charAt(1)) {
            case 'R':
                color = CARD_COLOR.RED;
                break;
            
            case 'Y':
                color = CARD_COLOR.YELLOW;
                break;
            
            case 'G':
                color = CARD_COLOR.GREEN;
                break;
            
            case 'B':
                color = CARD_COLOR.BLUE;
                break;
            
            case 'J':
                color = CARD_COLOR.JOKER;
                break;
            
            default:
                throw (new IllegalArgumentException("illegal name: color"));
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public Card asJoker() {
        this.isJoker = true;
        
        if (name.length() == 2) {
            name += 'J';
        } else {
            name = name.substring(0, 2) + 'J';
        }

        return this;
    }
}
