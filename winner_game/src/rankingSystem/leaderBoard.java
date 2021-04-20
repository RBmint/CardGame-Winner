package rankingSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class leaderBoard {
    private final ArrayList<leaderPlayer> players;
    private final ArrayList<matchHistory> matchHistories;

    public leaderBoard() {
        this.players = new ArrayList<>();
        this.matchHistories = new ArrayList<>();
    }

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

    public void writePlayers() throws IOException {
        FileWriter myWriter = new FileWriter("winner_game/src/rankingSystem/leaderPlayers.txt", false);
        for (int i = 0; i < players.size(); i++) {
            String toWrite = String.format("%s;%x\n", players.get(i).getName(), players.get(i).getScore());
            myWriter.write(toWrite);
        }
        System.out.println("leaderPlayers.txt has been updated.");
        myWriter.close();
    }

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

    public void addMatchHistory(String winner, String[] players) {
        matchHistory toAdd = new matchHistory(winner, players);
        matchHistories.add(toAdd);
    }

    public void clearAll() throws IOException {
        this.players.clear();
        writePlayers();
        this.matchHistories.clear();
        writeMatchHistories();
    }

    public ArrayList<leaderPlayer> getPlayers() {
        return this.players;
    }

    public ArrayList<matchHistory> getMatchHistories() {
        return this.matchHistories;
    }

}
