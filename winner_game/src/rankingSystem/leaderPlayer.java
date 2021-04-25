package rankingSystem;

/**
 * leading player class that store all necessary data(name and score) in this object
 */
public class leaderPlayer {
    private final String playerName;
    private int score;

    /**
     * constructor
     * @param playerName leading player's name
     * @param score leading player's score
     */
    public leaderPlayer(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    /**
     * name getter
     * @return leading player's name
     */
    public String getName() {
        return this.playerName;
    }

    /**
     * score getter
     * @return leading player's score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * score setter
     * @param newScore the new score set to the leading player
     */
    public void setScore(int newScore) {
        this.score = newScore;
    }

}
