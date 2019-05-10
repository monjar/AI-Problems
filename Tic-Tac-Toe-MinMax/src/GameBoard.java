import java.util.Arrays;

public class GameBoard {
    private int boardSize;
    private char [][] cells;

    GameBoard(int boardSize){
        this.boardSize = boardSize;
        this.cells = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = ' ';
            }
        }
    }
    GameBoard(char[][] cells){
        this.boardSize =  cells.length;
        this.cells =  new char[boardSize][boardSize];
        //this.cells = Arrays.copyOf(cells ,size);
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize ; j++) {
                this.cells[i][j]= cells[i][j];
            }
        }
    }
    public boolean putOnBoard(char c, Cord cord){
        return putOnBoard(c, cord.getRow(), cord.getCol());
    }

    private boolean putOnBoard(char c, int i, int j){
        if (cells [i][j] == ' '){
            cells [i][j] = Character.toLowerCase(c);
            return true;
        }
        else
            return false;
    }

    public char winner(){
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
        if (!this.isFinished())
            return ' ';
        return 'd';
    }

    public boolean isFinished(){
        boolean done = true;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize ; j++) {
                if (cells [i][j] == ' ')
                    done = false;
            }
        }
        return done;
    }

    public GameBoard makeCopy(){
        return new GameBoard(this.cells);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void print(){
        System.out.println("\n");
        System.out.print("--");
        for (int j = 0; j < this.boardSize  ; j++) {
            if (j == this.boardSize - 1)
                System.out.print("---");
            else
                System.out.print("----");
        }

        System.out.println();
        for (int i = 0; i < this.boardSize ; i++) {
            System.out.print("| ");
            for (int j = 0; j < this.boardSize; j++) {
                System.out.print(cells[i][j] + " | ");
            }
            System.out.println();
            System.out.print("--");
            for (int j = 0; j < this.boardSize  ; j++) {
                if (j == this.boardSize - 1)
                    System.out.print("---");
                else
                    System.out.print("----");
            }
            System.out.println();
        }
        System.out.println("\n");

    }
}
