package rankingSystem;

import java.util.ArrayList;

public class matchHistory {
    private String[] players;
    private String winner;

    public matchHistory(String winner, String[] players) {
        this.players = players;
        this.winner = winner;
    }

    public String[]  getPlayers() {
        return this.players;
    }

    public String getWinner() {
        return this.winner;
    }


}
