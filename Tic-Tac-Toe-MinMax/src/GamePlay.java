public class GamePlay {

    private boolean isXBot;
    private boolean isOBot;
    private final char starter = 'x';
    private GameBoard board;

    GamePlay(boolean isXBot, boolean isOBot, int boardSize){
        this.isOBot = isOBot;
        this.isXBot = isXBot;
        this.board = new GameBoard(boardSize);
    }

    public void start(){
        boolean gameIsOn = true;
        char turn = starter;
        while (gameIsOn){
            

        }
    }



}
