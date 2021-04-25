package rankingSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * leader board class that implements the game ranking system
 * including leading players, match histories, features of r/w and clear.
 */
public class leaderBoard {
    private final ArrayList<leaderPlayer> players;
    private final ArrayList<matchHistory> matchHistories;

    /**
     * constructor
     */
    public leaderBoard() {
        this.players = new ArrayList<>();
        this.matchHistories = new ArrayList<>();
    }

    /**
     * read leading players from "leaderPlayers.txt"
     * @throws Exception file not found
     */
    public void readPlayers() throws Exception {
        Scanner scanner = new Scanner(new File("winner_game/src/rankingSystem/leaderPlayers.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break; // last line
            }
            if (line.charAt(line.length()-1) == '\n') {
                line = line.substring(0, line.length()-1);
                System.out.println("last char is removed");
            }
            String[] args = line.split(";");
            if (args.length != 2) {
                throw new Exception("Parsing wrong format: length != 2");
            }
            leaderPlayer player = new leaderPlayer(args[0], Integer.parseInt(args[1]));
            this.players.add(player);
        }
    }

    /**
     * read match histories from "matchHistories.txt"
     * @throws Exception file not found
     */
    public void readMatchHistories() throws Exception {
        Scanner scanner = new Scanner(new File("winner_game/src/rankingSystem/matchHistories.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break; // last line
            }
            if (line.charAt(line.length()-1) == '\n') {
                line = line.substring(0, -1);
                System.out.println("last char is removed");
            }

            String[] args = line.split(";");
            if (args.length != 4) {
                throw new Exception("Parsing wrong format: length != 4");
            }
            String winner = args[0];
            String[] players = Arrays.copyOfRange(args, 1, args.length);
            assert players.length == 3;
            matchHistory match = new matchHistory(winner, players);
            this.matchHistories.add(match);
        }
    }

    /**
     * write current leading players to "leaderPlayers.txt"
     * @throws IOException ioException
     */
    public void writePlayers() throws IOException {
        FileWriter myWriter = new FileWriter("winner_game/src/rankingSystem/leaderPlayers.txt", false);
        for (int i = 0; i < players.size(); i++) {
            String toWrite = String.format("%s;%x\n", players.get(i).getName(), players.get(i).getScore());
            myWriter.write(toWrite);
        }
        System.out.println("leaderPlayers.txt has been updated.");
        myWriter.close();
    }

    /**
     * write current match histories to "matchHistories.txt"
     * @throws IOException ioException
     */
    public void writeMatchHistories() throws IOException {
        FileWriter myWriter = new FileWriter("winner_game/src/rankingSystem/matchHistories.txt", false);
        for (matchHistory match : matchHistories) {
            StringBuilder toWrite = new StringBuilder(match.getWinner());
            for (String player : match.getPlayers()) {
                toWrite.append(";").append(player);
            }
            toWrite.append("\n");
            myWriter.write(String.valueOf(toWrite));
        }
        System.out.println("matchHistory.txt has been updated.");
        myWriter.close();
    }

    /**
     * update a leading player's score
     * @param name the player to be updated
     * @param score the new score for the player
     */
    public void updatePlayer(String name, int score) {
        for (leaderPlayer player: this.players) {
            if (name == player.getName()) {
                //this player is already in the leaderBoard,
                System.out.println("updating score of " + name);
                player.setScore(score);
                return;
            }
        }
        //add new player to the leaderboard
        leaderPlayer newPlayer = new leaderPlayer(name, score);
        System.out.println("adding " + newPlayer.getName() + " to the leader board");
        this.players.add(newPlayer);
    }

    /**
     * add a new match history
     * @param winner the winner of the game to be added
     * @param players the players of the game to be added
     */
    public void addMatchHistory(String winner, String[] players) {
        matchHistory toAdd = new matchHistory(winner, players);
        matchHistories.add(toAdd);
    }

    /**
     * clear all history data in the ranking system
     * @throws IOException ioException
     */
    public void clearAll() throws IOException {
        this.players.clear();
        writePlayers();
        this.matchHistories.clear();
        writeMatchHistories();
    }

    /**
     * getter of leading players
     * @return leading players
     */
    public ArrayList<leaderPlayer> getPlayers() {
        return this.players;
    }

    /**
     * getter of match histories
     * @return match histories
     */
    public ArrayList<matchHistory> getMatchHistories() {
        return this.matchHistories;
    }

}
