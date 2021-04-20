package rankingSystem;

public class leaderPlayer {
    private final String playerName;
    private int score;

    public leaderPlayer(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getName() {
        return this.playerName;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }

}
