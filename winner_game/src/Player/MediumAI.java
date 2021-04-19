package Player;

import Game.SinglePlay;
import Card.Card;
public class MediumAI extends BasicAI {

    public MediumAI(String newName, boolean isAI) {
        super(newName, isAI);
    }

    @Override
    public SinglePlay playAHand(SinglePlay lastPlay) {
        SinglePlay xx = super.playAHand(lastPlay);
        if (xx != null) {
            return xx;
        }
        if (lastPlay.getComboType().getType().equals(STRAIGHT)) {
            if (hasStraight()) {
                return playStraight();
            }
        }

        return null;
    }

    //TODO: playBomb, playStraight, playFullhouse, playFreely, playSecondLargest, playConPairs


    @Override
    public SinglePlay playSingle(SinglePlay lastPlay) {
        SinglePlay bestPlay = null;
        for(int i = 0; i < getAllCards().size(); i++) {
            SinglePlay thisPlay = new SinglePlay(new Card[]{getAllCards().get(i)}, getPlayerName());
            if (thisPlay.compareSingle(lastPlay)) {
                if (bestPlay == null) {
                    bestPlay = thisPlay;
                }
                if (bestPlay.compareSingle(thisPlay)) {
                    bestPlay = thisPlay;
                }
            }
        }
        return bestPlay;
    }

    @Override
    public SinglePlay playAPair(SinglePlay lastPlay) {
        return null;
    }
    public boolean hasStraight() {
        return false;
    }

    public SinglePlay playStraight() {
        return null;
    }
}
