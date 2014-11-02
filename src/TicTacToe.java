/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tyler_Atiburcio
 */
public class TicTacToe {
    
    private char[][] board;
    
    protected int numOfPlays = 0;
    
    private boolean isTie = false;
    
    private static final int[][] VALID_LOC = {{1,2,3},{4,5,6},{7,8,9}};
    
    private Player[][] playerGrid = new Player[3][3];
    
    public TicTacToe()
    {
        board = new char[3][3];
    }
    
    public char[][] getBoard()
    {
        return this.board;
    }
    
    public void insertPlay(int pos, Player p)
    {
        char play = p.getType();
        if(play != 'X' && play != 'O') return;
        else this.numOfPlays++;
        switch(pos)
        {
            case 1:
            {
                board[0][0] = play;
                playerGrid[0][0]= p;
                break;
            }
            case 2:
            {
                board[0][1] = play;
                playerGrid[0][1]= p;
                break;
            }
            case 3:
            {
                board[0][2] = play;
                playerGrid[0][2]= p;
                break;
            }
            case 4:
            {
                board[1][0] = play;
                playerGrid[1][0]= p;
                break;
            }
            case 5:
            {
                board[1][1] = play;
                playerGrid[1][1]= p;
                break;
            }
            case 6:
            {
                board[1][2] = play;
                playerGrid[1][2]= p;
                break;
            }
            case 7:
            {
                board[2][0] = play;
                playerGrid[2][0]= p;
                break;
            }
            case 8:
            {
                board[2][1] = play;
                playerGrid[2][1]= p;
                break;
            }
            case 9:
            {
                board[2][2] = play;
                playerGrid[2][2]= p;
                break;
            }
        }
        
    }
    
    public boolean validatePlay(int pos)
    {
        if(pos < 1 || pos > 9) return false;
        int count = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(count == pos)
                {
                    if(board[i][j] == 'X' || board[i][j] == 'O')
                    {
                        return false;
                    }
                    else return true;
                }
                count++;
            }
            
        }
        return false;
    }
    
    public static void printValidLoc()
    {
        System.out.println("\nValid Positions [1-9]");
        int count = 1;
        for (int i = 0; i < VALID_LOC.length; i++) {
            for (int j = 0; j < VALID_LOC[i].length; j++) {
                count++;
                if(count > 3)
                {
                    System.out.print(VALID_LOC[i][j]);
                    System.out.println("");
                    count = 1;
                }
                else System.out.print(VALID_LOC[i][j] + " | ");
            }
            
        }
        System.out.println("");
    }
    
    public boolean hasWinner()
    {
        if(this.numOfPlays < 6) return false;
        if(this.numOfPlays >= 9)
        {
            this.isTie = true;
            return true;
        }
        if(this.board[0][2] == this.board[0][1] && this.board[0][2] == this.board[0][0]) return true;
        else if(this.board[1][2] == this.board[1][1] && this.board[1][2] == this.board[1][0]) return true;
        else if(this.board[2][2] == this.board[2][1] && this.board[2][2] == this.board[2][0]) return true;
        else if(this.board[1][0] == this.board[0][0] && this.board[1][0] == this.board[2][0]) return true;
        else if(this.board[1][1] == this.board[0][1] && this.board[1][1] == this.board[2][1]) return true;
        else if(this.board[1][2] == this.board[0][2] && this.board[1][2] == this.board[2][2]) return true;
        else if(this.board[1][1] == this.board[0][0] && this.board[1][1] == this.board[2][2]) return true;
        else if(this.board[1][1] == this.board[0][2] && this.board[1][1] == this.board[2][0]) return true;
        else return false;
    }
    
    
    public Player getOwner()
    {
        if(this.isTie) return null;
        if(this.board[0][2] == this.board[0][1] && this.board[0][2] == this.board[0][0]) return this.playerGrid[0][2];
        else if(this.board[1][2] == this.board[1][1] && this.board[1][2] == this.board[1][0]) return this.playerGrid[1][2];
        else if(this.board[2][2] == this.board[2][1] && this.board[2][2] == this.board[2][0]) return this.playerGrid[2][2];
        else if(this.board[1][0] == this.board[0][0] && this.board[1][0] == this.board[2][0]) return this.playerGrid[1][0];
        else if(this.board[1][1] == this.board[0][1] && this.board[1][1] == this.board[2][1]) return this.playerGrid[1][1];
        else if(this.board[1][2] == this.board[0][2] && this.board[1][2] == this.board[2][2]) return this.playerGrid[1][2];
        else if(this.board[1][1] == this.board[0][0] && this.board[1][1] == this.board[2][2]) return this.playerGrid[1][1];
        else if(this.board[1][1] == this.board[0][2] && this.board[1][1] == this.board[2][0]) return this.playerGrid[1][1];
        else return null;
    }
    
    @Override
    public String toString() {
        System.out.println("");
        int count = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                count++;
                if(count > 3)
                {
                    System.out.print(board[i][j]);
                    System.out.println("");
                    count = 1;
                }
                else System.out.print(board[i][j] + " | ");
            }
            
        }
        return "";
    }
    
    
    
}
