package rankingSystem;

/**
 * match history class that stores the data necessary for a single match history
 */
public class matchHistory {
    private String[] players;
    private String winner;

    /**
     * constructor
     * @param winner winner of this game
     * @param players players of this game
     */
    public matchHistory(String winner, String[] players) {
        this.players = players;
        this.winner = winner;
    }

    /**
     * players getter
     * @return players
     */
    public String[]  getPlayers() {
        return this.players;
    }

    /**
     * winner getter
     * @return winner
     */
    public String getWinner() {
        return this.winner;
    }


}
