package winner.game;

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
    public boolean compare() {
        return false;
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
