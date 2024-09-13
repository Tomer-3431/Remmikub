import java.util.ArrayList;
import java.util.List;

public class Seria {
    public enum SERIA_TYPE {
        GROUP,
        RUN,
        ILLEGAL
    }

    Card[] cards;

    public Seria(Card[] cards) {
        this.cards = cards;
        if (!isLegal()) {
            throw (new IllegalArgumentException("seria is illegal"));
        } else {
            System.out.println("Seria is Legal!!!!");
        }
    }

    public boolean isLegal() {
        
        if (cards.length < 3) {
            System.out.println("Seria is illegal: not enogth cards" + "\n errorNum = " + String.valueOf(0) + "\n line = " + String.valueOf(26));
            return false;
        }
        
        SERIA_TYPE canBe = SERIA_TYPE.ILLEGAL;
        List<Card.CARD_COLOR> group = new ArrayList<Card.CARD_COLOR>();
        Card.CARD_COLOR currentColor = null;
        int jokerCount = 0;

        for (int i = 0; i < cards.length; i++) {
            
            if (cards[i].isJoker) {
                jokerCount++;
                continue;
            }

            switch (canBe) {

                case GROUP:
                    if (cards[i].num == cards[0].num) {
                        if (!group.contains(cards[i].color)) {
                            group.add(cards[i].color);
                            continue;
                        } else {
                            System.out.println("Seria is illegal: same color at a group" + "\n errorNum = " + String.valueOf(1) + "\n line = " + String.valueOf(50));
                            return false;
                        }                    
                    } else {
                        System.out.println("Seria is illegal: not all same number at a group" + "\n errorNum = " + String.valueOf(2) + "\n line = " + String.valueOf(54));
                        return false;
                    }

                case RUN:
                    if (cards[i].num == cards[i-1].num + 1) {
                        if (cards[i].color == currentColor) {
                            continue;
                        } else {
                            System.out.println("seria is illegal: not same color at a run" + "\n errorNum = " + String.valueOf(3) + "\n line = " + String.valueOf(63));
                            return false;
                        }
                    } else {
                        System.out.println("seira is illegal: numbers do not goes up in a run" + "\n errorNum = " + String.valueOf(4) + "\n line = " + String.valueOf(67));
                        return false;
                    }

                case ILLEGAL:
                    if (i == cards.length - 1) {
                        if (jokerCount == i) {
                            return true;
                        } else {
                            System.out.println("Seria is illegal: could not determined the seria type" + "\n errorNum = " + String.valueOf(5) + "\n line = " + String.valueOf(76));
                            return false;
                        }
                    } else 
                    
                    if (cards[i].num == cards[i+1].num) {
                        canBe = SERIA_TYPE.GROUP;
                        
                        if (!group.contains(cards[i].color)){
                            group.add(cards[i].color);
                        } else {
                            System.out.println("Seria is illegal: same color at a group" + "\n errorNum = " + String.valueOf(6) + "\n line = " + String.valueOf(88));
                            return false;
                        }

                        continue;
                    } /*TODO fix for cases like  1B J J  */
                    else if (cards[i].num == cards[i+1].num - 1) {
                        canBe = SERIA_TYPE.RUN;

                        if (cards[i].color == cards[i+1].color) {
                            currentColor = cards[i].color;
                        } else {
                            System.out.println("Seria is illegal: not same color at a run" + "\n errorNum = " + String.valueOf(7) + "\n line = " + String.valueOf(101));
                            return false;
                        }

                        continue;
                    } else {
                        System.out.println("Seria is illegal: could not determined the seria type" + "\n errorNum = " + String.valueOf(8) + "\n line = " + String.valueOf(107));
                        return false;
                    }
            }
        }
        
        return true;
    }
}
