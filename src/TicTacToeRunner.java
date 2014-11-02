
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tyler_Atiburcio
 */
public class TicTacToeRunner {
    
    private static Player player, computer;
    private static TicTacToe game;
    
    
    public static void main(String[] args) {
        String input = "";
        Scanner scan = new Scanner(System.in);
        
        do{
            System.out.println("What would you like to be 'X' or 'O'?");
            input = scan.next().toUpperCase();
            
        }while(!input.matches("X|O"));
        
        if(input.equals("X"))
        {
            player = new Player('X');
            computer = new Player('O');
        }
        else if(input.equals("O"))
        {
            player = new Player('O');
            computer = new Player('X');
        }
        else return;
        
        game = new TicTacToe();
        
        do{
            
            if(player.getType() == 'X')
            {
                game.printValidLoc();
                game.toString();
                userPlay();
                computerPlay();
            }
            else
            {
                computerPlay();
                game.printValidLoc();
                game.toString();
                userPlay();
                        
            }
            
            
        }while(!game.hasWinner());
        System.out.println("\n\n" + game);
        if(game.getOwner() == player) System.out.println("Player Wins!");
        else if(game.getOwner() == computer)System.out.println("Computer Won!");
        else System.out.println("Game was a Tie");
    }
    
    public static void userPlay()
    {
        if(game.hasWinner()) return;
            int user = -1;
            do
            {
                
                user = player.getPlay();
            }while(!game.validatePlay(user) && !game.hasWinner());
            game.insertPlay(user, player);
    }
    
    public static void computerPlay()
    {
        if(game.hasWinner()) return;
            int compPlay = -1;
            do{
                compPlay = computer.getRandomPlay();
            }while(!game.validatePlay(compPlay) && !game.hasWinner());
            game.insertPlay(compPlay, computer);
    }
}

