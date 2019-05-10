import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GamePlay {

    private Map <Character , Boolean> isBot = new HashMap<>();
    private final char starter = 'x';
    private GameBoard board;

    GamePlay(boolean isXBot, boolean isOBot, int boardSize){
        isBot.put('x' ,isXBot);
        isBot.put('o' ,isOBot);
        this.board = new GameBoard(boardSize);
    }

    public void start(){
        char turn = starter;
        while (board.winner() == ' '){
            makeMove(turn);
            board.print();
            if (turn == 'x')
                turn = 'o';
            else
                turn = 'x';
        }
        if (board.winner() == 'd')
            System.out.println("It's a DRAW!");
        else
            System.out.println(Character.toUpperCase(board.winner()) + " Wins!");
    }

    private void makeMove(char turn){
        System.out.println("It's "+turn+"'s turn: ");
        if (isBot.get(turn)) {
            MiniMaxAgent agent = new MiniMaxAgent(turn);
            agent.buildTree(turn, board.makeCopy(),0 );
            board.putOnBoard(turn, agent.getAgentMove());
        }
        else {
            boolean done = false;
            while (!done) {
                Scanner in = new Scanner(System.in);
                int i = in.nextInt(), j = in.nextInt();
                if ( i > board.getBoardSize() || i < 0 || j > board.getBoardSize() || j < 0 )
                    System.out.println("Wrong move!");
                else {
                    done = board.putOnBoard(turn, new Cord(i, j));
                    if (!done)
                        System.out.println("Wrong move!");
                }
            }

        }

    }
}
