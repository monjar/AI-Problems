public class MiniMaxAgent {
    private char side;
    private Cord agentMove;
    MiniMaxAgent(char side){
        this.side = side;
    }


    public int buildTree(char turn, GameBoard board, int depth){
        char winner = board.winner();
        if (winner == 'd')
            return 0;
        else if (winner == side)
            return 1;
        else if (winner != '-' )
            return -1;

        else {
            int max = -1 ,min = 1;
            for (int i = 0; i < board.getBoardSize() ; i++) {
                for (int j = 0; j < board.getBoardSize() ; j++) {
                    GameBoard gb = board.makeCopy();
                    if (gb.putOnBoard(turn , i , j)){
                        int res;
                        if (turn == 'x')
                            res = buildTree('o' , gb , depth+1);
                        else
                            res = buildTree('x' , gb , depth+1);
                        if (res > max) {
                            max = res;
                            if (depth == 0)
                                this.agentMove = new Cord(i, j);
                        }
                        if (res < min)
                            min = res;
                    }
                }

            }
            if (turn == this.side)
                return max;
            else
                return min;

        }


    }



}
