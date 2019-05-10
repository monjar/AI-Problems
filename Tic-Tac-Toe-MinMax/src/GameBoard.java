import java.util.Arrays;

public class GameBoard {
    private int boardSize;
    private char [][] cells;

    GameBoard(int boardSize){
        this.boardSize = boardSize;
        cells = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = '-';
            }
        }
    }
    GameBoard(char[][] cells){
        int size = cells.length;
        this.cells = Arrays.copyOf(cells ,size);
    }

    public boolean putOnBoard(char c, int i, int j){
        if (cells [i][j] == '-'){
            cells [i][j] = Character.toLowerCase(c);
            return true;
        }
        else
            return false;
    }

    public char winner(){
        if (!this.isFinished())
            return '-';

        for (int i = 0; i < boardSize ; i++) {
            int xScore = 0, oScore=0;
            for (int j = 0; j < boardSize; j++) {
                if (cells[i][j] == 'x')
                    xScore++;
                if (cells[i][j] == 'o')
                    oScore++;
            }
            if (xScore == 3)
                return 'x';
            if (oScore == 3)
                return 'o';
        }
        for (int j = 0; j < boardSize ; j++) {
            int xScore = 0, oScore=0;
            for (int i = 0; i < boardSize ; i++) {
                if (cells[i][j] == 'x')
                    xScore++;
                if (cells[i][j] == 'o')
                    oScore++;
            }
            if (xScore == 3)
                return 'x';
            if (oScore == 3)
                return 'o';
        }
        int xScore = 0, oScore=0;
        for (int r = 0; r < boardSize ; r++) {
            if (cells[r][r] == 'x')
                xScore++;
            if (cells[r][r] == 'o')
                oScore++;
        }
        if (xScore == 3)
            return 'x';
        if (oScore == 3)
            return 'o';
        xScore = 0;
        oScore=0;
        for (int r = 0; r < boardSize ; r++) {
            if (cells[r][boardSize - r - 1] == 'x')
                xScore++;
            if (cells[r][boardSize - r - 1] == 'o')
                oScore++;
        }
        if (xScore == 3)
            return 'x';
        if (oScore == 3)
            return 'o';
        return 'd';
    }

    private boolean isFinished(){
        boolean done = true;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize ; j++) {
                if (cells [i][j] == '-')
                    done = false;
            }
        }
        return done;
    }

    public GameBoard makeCopy(){
        GameBoard gb = new GameBoard(this.cells);
        return gb;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
