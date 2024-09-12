public class Seria {
    public enum SERIA_TYPE {
        GROUP,
        RUN
    }

    Card[] cards;

    // boolean isLegal() {
    //     boolean isGroup = false;
    //     boolean isRun = false;
    //     if (cards[0].num == cards[1].num) {
    //         isGroup = true;
    //     } else if (cards[0].num + 1 == cards[1].num) {
    //         isRun = true;
    //     } else if (cards[0].color == Card.CARD_COLOR.JOKER) {
    //         if (cards[1].num == cards[2].num) {
    //             isGroup = true;
    //         } else if (cards[1].num + 1 == cards[2].num) {
    //             isRun = true;
    //         } else if (cards[1].color == Card.CARD_COLOR.JOKER)
    //     }
    // }
}
