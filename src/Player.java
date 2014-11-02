
import java.util.Random;
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
public class Player {
    
    protected Scanner scan;
    
    private char type;
    
    
    public Player(char c)
    {
        if(c != 'X' && c != 'O') return;
        this.type = c;
        this.scan = new Scanner(System.in);
    }
    
    public int getPlay()
    {
        int input = 0;
        do{
            System.out.println("Where do you want to play your next move? [1-9]");
            input = scan.nextInt();
        }while(input < 1 || input > 9 );
        return input;
    }
    
    public int getRandomPlay()
    {
        Random bag = new Random();
        return bag.nextInt(9) + 1;
    }
    
    public char getType()
    {
        return this.type;
    }
    
}
