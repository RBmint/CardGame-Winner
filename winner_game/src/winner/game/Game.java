package winner.game;

import java.util.Stack;

public class Game {
    String exampleArray = "1,3,5,6";
    String[] inputAsArray = exampleArray.split(",");
    int[] indexOfCards = new int[inputAsArray.length];
    Stack<SinglePlay> pastPlays;
    Game() {
//        Scanner scanner = new Scanner(System.in);
//        String inputArray = scanner.next();

        String exampleArray = "1,3,5,6";
        String[] inputAsArray = exampleArray.split(",");
        for (int i = 0; i < inputAsArray.length; i++) {
            indexOfCards[i] = Integer.parseInt(inputAsArray[i]);
        }

    }


    public void printsth() {
        for(int x : indexOfCards) {
            System.out.println(x);
        }
    }
    public SinglePlay getCurrentPlay() {
        return pastPlays.peek();
    }
//    player1.play(index1)
//    player2.play(new SinglePlay(123), player2.getid())
}
