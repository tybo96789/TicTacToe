
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**Handles all user aspect of the game
 *
 * @author Tyler_Atiburcio
 */
public class Player {
    
    protected Scanner scan;
    
    private char type;
    
    /** Default constructor for player class must pass the player representation 
     * in terms of either 'x' or 'o'
     * 
     * @param c 'x' or 'o'
     */
    public Player(char c)
    {
        if(c != 'X' && c != 'O') return;
        this.type = c;
        this.scan = new Scanner(System.in);
    }
    /** getPlay method takes in user input and asks for a number between 1-9 inclusive
     * 
     * @return A Number between 1-9 (Inclusive)
     */
    public int getPlay()
    {
        int input = 0;
        try{
            
            do{
                System.out.println("Where do you want to play your next move? [1-9]");
                input = Integer.parseInt(scan.nextLine());
            }while(input < 1 || input > 9 );
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            getPlay();
        }
        return input;
    }
    
    /** getRandomPlay method is used to get a random number from 1-9 which is
     * index on the board
     * 
     * @return A number corresponding to a place on the board
     */
    public int getRandomPlay()
    {
        Random bag = new Random();
        return bag.nextInt(9) + 1;
    }
    
    /**
     * 
     * @return The player's Representation either 'x' or 'o'
     */
    public char getType()
    {
        return this.type;
    }
    
}
