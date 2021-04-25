package Tests;

import org.junit.jupiter.api.Test;
import rankingSystem.leaderBoard;
import rankingSystem.leaderPlayer;
import rankingSystem.matchHistory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for the leader board class
 */
class leaderBoardTest {

    @Test
    void writePlayer() throws IOException {
        leaderBoard testBoard = new leaderBoard();
        testBoard.updatePlayer("Ricky", 0);
        testBoard.updatePlayer("Royce", 0);
        testBoard.updatePlayer("BasicAI", 0);
        testBoard.writePlayers();
        assertEquals(3, testBoard.getPlayers().size());
    }

    @Test
    void readPlayer() throws Exception {
        leaderBoard testBoard = new leaderBoard();
        testBoard.readPlayers();
        ArrayList<leaderPlayer> players = testBoard.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName());
            System.out.println(players.get(i).getScore());
        }
        assertEquals(3, testBoard.getPlayers().size());
    }

    @Test
    void writeMatchHistories() throws IOException {
        leaderBoard testBoard = new leaderBoard();
        String[] players = new String[]{"Ricky", "BasicAI", "MediumAI"};
        testBoard.addMatchHistory("Ricky", players);
        String[] playersTwo = new String[]{"Royce", "BasicAI", "MediumAI"};
        testBoard.addMatchHistory("Royce", playersTwo);
        testBoard.writeMatchHistories();
        assertEquals(2, testBoard.getMatchHistories().size());
    }

    @Test
    void readMatchHistories() throws Exception {
        leaderBoard testBoard = new leaderBoard();
        testBoard.readMatchHistories();
        ArrayList<matchHistory> matchHistories = testBoard.getMatchHistories();
        for (matchHistory match : matchHistories) {
            System.out.println(match.getWinner());
        }
        assertEquals(2, testBoard.getMatchHistories().size());
    }

    @Test
    void clearAll() throws Exception {
        leaderBoard testBoard = new leaderBoard();
        testBoard.readPlayers();
        testBoard.readMatchHistories();
        testBoard.clearAll();
        assertTrue(testBoard.getPlayers().size()==0);
        assertTrue(testBoard.getMatchHistories().size()==0);
    }
}