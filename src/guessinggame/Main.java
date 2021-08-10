package guessinggame;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Cart[][] carts = new Cart[4][4];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        carts[0][0] = new Cart('E');
        carts[0][1] = new Cart('A');
        carts[0][2] = new Cart('B');
        carts[0][3] = new Cart('F');
        carts[1][0] = new Cart('G');
        carts[1][1] = new Cart('A');
        carts[1][2] = new Cart('D');
        carts[1][3] = new Cart('H');
        carts[2][0] = new Cart('F');
        carts[2][1] = new Cart('C');
        carts[2][2] = new Cart('D');
        carts[2][3] = new Cart('H');
        carts[3][0] = new Cart('E');
        carts[3][1] = new Cart('G');
        carts[3][2] = new Cart('B');
        carts[3][3] = new Cart('C');
        
        while (isGameFinished() == false) {
            
            gameBoard();
            
            makeAGuess();
            
            wait(1500);
            
            clearOldVersion();     
        }
        System.out.println("Good Job, You finished the game !");
        
    }
    public static void makeAGuess() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("First Guess (Enter the row and column number of the card you want to open): ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();
        
        carts[i1-1][j1-1].setGuess(true);
        gameBoard();
        
        System.out.print("Second Guess (Enter the row and column number of the card you want to open): ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();
        
        if (carts[i1-1][j1-1].getValue() == carts[i2-1][j2-1].getValue()) {
            System.out.println("True Guess. Good Job!");
            carts[i2-1][j2-1].setGuess(true);    
        }
        else {
            System.out.println("Wrong Guess...Try Again");
            carts[i1-1][j1-1].setGuess(false);     
        }   
    }
    public static boolean isGameFinished() {
        
        for (int i =  0 ; i < 4; i++){
            for (int j = 0 ; j < 4 ; j++) {
                if (carts[i][j].isGuess() == false) {
                    return false;            
                }    
            }
        }
        return true;
    }
    public static void gameBoard(){
    	System.out.println("  1    2    3    4  ");
        for (int i = 0 ;  i < 4 ; i++) {
            System.out.println("-------------------");
            //System.out.println(i);
            for (int j = 0 ; j < 4 ; j++) {
                
                if (carts[i][j].isGuess()) {
                    System.out.print(" |" + carts[i][j].getValue() + "| ");
                    
                }
                else {
                    System.out.print(" | | ");
                }
            }
            System.out.println(i+1);
            System.out.println("");
        }
        System.out.println("-------------------");
    }
    public static void clearOldVersion() {
    	
    		try { //to clear old version of mazeTable
    			Process exitCode;
    			if( System.getProperty( "os.name" ).startsWith( "Window" ) ) {
    				exitCode = Runtime.getRuntime().exec("cls");
    			}else {
    				exitCode = Runtime.getRuntime().exec("clear");
    			}
    		}catch (IOException e) {
    			for(int i = 0; i < 1000; i++) {
    				System.out.println();
    			}
    		}
    }
    public static void wait(int ms)
    {
    	try
    	{
    		Thread.sleep(ms);
    	}
    	catch(InterruptedException ex)
    	{
    		Thread.currentThread().interrupt();
    	}
    }

}


