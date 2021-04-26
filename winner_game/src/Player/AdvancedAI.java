package Player;

import Game.SinglePlay;

public class AdvancedAI extends MediumAI {
    /**
     * The constructor is the same as in class Player.
     * @param newName the name of the AI player
     * @param isAI usually set to true because it is an AI player.
     */
    public AdvancedAI(String newName, boolean isAI) {
        super(newName, isAI);
    }


    @Override
    public SinglePlay playAHand(SinglePlay lastPlay) {
        SinglePlay bestPlay = super.playAHand(lastPlay);
        if (bestPlay != null) {
            return bestPlay;
        }
        System.out.println("The Advanced AI cannot make any play and has to skip this turn.");
        return null;
    }

        @Override
        public SinglePlay playFreely() {
            if (checkForPossibleStraight() != null) {
                return checkForPossibleStraight();
            }
            if (checkForPossibleConsecutivePairs() != null) {
                return checkForPossibleConsecutivePairs();
            }
            if (checkForPossibleFullHouse() != null) {
                return checkForPossibleFullHouse();
            }
            if (checkForPossibleThreeOfAKind() != null) {
                return checkForPossibleThreeOfAKind();
            }
            if (checkForPossiblePair() != null) {
                return checkForPossiblePair();
            }
            return checkForSmallestSingle();
    }

     public SinglePlay checkForPossibleStraight() {

     }

     public SinglePlay checkForPossibleConsecutivePairs() {

     }
     public SinglePlay checkForPossibleFullHouse() {

     }
     public SinglePlay checkForPossibleThreeOfAKind() {


     }
     public SinglePlay checkForPossiblePair() {

     }
     public SinglePlay checkForSmallestSingle() {

     }
}

