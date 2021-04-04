package winner.game;

//TODO: to be implemented in week 2
public class SinglePlay {
    private Card[] cards;
    private ComboType comboType;
    private String playerName;
//    private boolean canBePlayed;
    public SinglePlay(Card[] input, String inputPlayerName) {
        cards = input;
        comboType = new ComboType(cards);
        playerName = inputPlayerName;
    }
    public boolean compareCanBePlayed(SinglePlay lastPlay) {

        return true;
    }
    public String getPlayerName() {
        return playerName;
    }
    public ComboType getComboType() {
        return comboType;
    }
//    public boolean canBePlayed() {
//        return canBePlayed;
//    }
}
