import java.util.ArrayList;
import java.util.List;

public class Seria {
  public enum SERIA_TYPE {
    GROUP,
    RUN
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
      System.out.println("Seria is illegal: not enogth cards" + "\n errorNum = " + String.valueOf(0));
      return false;
    }

    List<Card.CARD_COLOR> groupColorList = new ArrayList<Card.CARD_COLOR>();
    int groupNum = 0;
    Card.CARD_COLOR runColor = null;
    SERIA_TYPE type = null;

    int i;
    for (i = 0; i < cards.length && cards[i].isJoker; i++);
    int j;
    for (j = i+1; j < cards.length && cards[j].isJoker; j++);

    if (cards[i].isJoker || cards[j].isJoker) {
      return true;
    }

    if (cards[i].num == cards[j].num) {
      groupColorList.add(cards[i].color);
      groupNum = cards[i].num;
      type = SERIA_TYPE.GROUP;
    } else if (cards[i].num == cards[j].num - (j - i)) {
      if ((cards[0].isJoker && cards[1].num == 1) || (cards[cards.length - 1].isJoker && cards[cards.length - 2].num == 13)) {
        System.out.println("error 7");
        return false;
      }
      runColor = cards[i].color;
      type = SERIA_TYPE.RUN;
    } else {
      System.out.println("error 1");
      return false;
    }
    
    for (int n = j; n < cards.length; n++) {
      
      if (cards[n].isJoker) {
        continue;
      }

      switch (type) {
        case GROUP:
          if (cards[n].num == groupNum) {
            if (!groupColorList.contains(cards[n].color)) {
              continue;
            } else {
              System.out.println("error 2");
              return false;
            }
          } else {
            System.out.println("error 3");
            return false;
          }
        
        case RUN:
          if (cards[n].num == cards[i].num + (n-i)) {
            if (cards[n].color == runColor) {
              continue;
            } else {
              System.out.println("error 4");
              return false;
            }
          } else {
            System.out.println("error 5");
            return false;
          }

        default:
          System.out.println("error 6");
          return false;
      }
    }

    return true;
  }
}
