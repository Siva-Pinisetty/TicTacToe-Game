package com.bridgelabz.newpackage;
import java.util.*;
public class TicTacToeGame {
	static char[] element;
	static char userchoice,computerchoice;
	static Scanner scan = new Scanner(System.in);
	static int usernumber;
	static Random random = new Random();
	static int[] computer,win;
	
	public static void main(String[] args) {
		System.out.println("Welcome to  TicTacToe game");
		
		boardLayout();
		
		choosingXorO();
		
		currentBoard();
		
		tossingCoin();
	}
	
	/**
	 * creating elements with null and displays board by calling method 
	 * @param elements='-'
	 * @return board layout
	 */
	private static void boardLayout() {
		element=new char[10];
		for(int i=1; i < 10; i++) {
			element[i]='-';
		}
		displayingBoard();
	}
	
	/**
	 * Displays board layout with marks and numbers
	 */
	private static void displayingBoard() {
		System.out.println("\n  "+element[1]+" | "+element[2]+" | "+element[3]+" ");
		System.out.println(" ----------- ");
		System.out.println("  "+element[4]+" | "+element[5]+" | "+element[6]+" ");
		System.out.println(" ----------- ");
		System.out.println("  "+element[7]+" | "+element[8]+" | "+element[9]+" \n");
	}
	
	/**
	 * Asking user to choose X or O
	 * @param X and O
	 * @return user choice, computer choice
	 */
	private static void choosingXorO() {
		System.out.println("Let's START the game\n\nChoose either 'X' or 'O' as your mark\n");
		userchoice= scan.next(). charAt(0);
		if (userchoice=='x' || userchoice=='o' || userchoice=='X' || userchoice=='O') {
			if(userchoice=='x' || userchoice=='X') {
				userchoice='X';
				computerchoice='O';
				System.out.println("\nNice! Your Mark is '"+userchoice+"' Mine is '"+computerchoice+"'");
			} else {
				computerchoice='X';
				userchoice='O';
				System.out.println("\nGreat! Your Mark is '"+userchoice+"' Mine is '"+computerchoice+"'");
			}
		} else {
			System.out.println("\nYour input is invalid. Again");
			choosingXorO();
		}
		System.out.println();
	}

	/**
	 * Converts elements in the board to numbers & marks and displays board by calling method
	 */
	private static void currentBoard() {
		int REDIX=10;
		System.out.println("\n");
	    for( int i=1; i<10; i++) {
	    	if (element[i] !='X'&&element[i] !='O') 
            element[i] = Character.forDigit(i,REDIX);
        }
	    displayingBoard();
	}

	/**
	 * Asking user for a slot number by displaying board with marks and numbers
	 */
	private static void userTurn() {
		currentBoard();
	    System.out.println("\nEnter a slot number from above to mark on it:\n");
	    usernumber=scan.nextInt();
	    if (usernumber < 1 || usernumber > 9 || element[usernumber]=='x' || element[usernumber]=='o') {
	    	System.out.println("Your input is Invalid");
	    	userTurn();
	    }else {
	    	element[usernumber]=userchoice;
	    	System.out.println("Ho! You go for '"+usernumber+"'." );
	    	checkingUserWin();
	    }
	}
	
	/**
	 * Determining who's is starting, user or computer by tossing a coin
	 *@param Head and Tail 
	 *@return Either Player turn or Computer's
	 */
	private static void tossingCoin() {   
	    System.out.println("Let me Toss a coin for who gonna play first\n\nJust choose either 1 for Head or 2 for Tail\n");
	    int option=scan.nextInt();
	    if ( option==1 || option==2 ) {
	    	int flip = random.nextInt (2)+1;
	    	if (flip==1) {
	    		System.out.println("\nBy tossing Coin it shows HEAD\n");
	    	} else {
	    		System.out.println("\nBy tossing Coin it shows TAIL\n");
	    	}
	    	if (flip == option) {
	    		System.out.println("WOW! Good guess. You have to start the game\n");
	    		userTurn();
	    	} else {
	    		System.out.println("Hurray! You lost. My Turn first\n");
	    		computerFirstTurn();
	    	}
	    } else {
	    	System.out.println("\nInvalid input Again");
	    	tossingCoin();
	    }
	}
	
	/**
	 * Making Computer First Turn as random from 1 to 9 and calls for user turn
	 * @return Computer option
	 */
	private static void computerFirstTurn() {
		computer=new int[9];
		int  computeroption = random.nextInt(9)+1;
		element[computeroption]=computerchoice;
		System.out.println("Fist I go for '"+computeroption+"' now its your turn.");
		userTurn();
	}
	
	/**
	 * Checking either user is win or not and calls for tie
	 */
	private static void checkingUserWin() {
	    for (int i=1;i<9;i++) {
	    	int win1 = array(i);
	    	win= new int[3];
	    	int j=0;
	    	while (win1>0) {
	    		int rem=win1%10;
	    		win[j]=rem;
	    		j++;
	    		win1=win1/10;
	    	}
	    	if (element[win[0]]==element[win[1]]&&element[win[1]]==element[win[2]]) {
	    		System.out.println("Excellent! Nice play. You are the winner");
	    		System.exit(1);
	    	}
	    }
	}
			
	/**
	 * Checking for a tie and calls for computer to make for winning
	 */
	public static void checkingTie() {
		for (int i=1; i<10; i++) {
			if (element[i]=='X' || element[i]=='O') {
				if (i==9) {
					System.out.println("Nice try! It's Tie");
					System.exit(1);
				}else {
				continue;
				}
			} else {
				computerWin();
			}
		}
	}

	/**
	 * Checking for computer win and calls for making user block
	 */
	public static void computerWin() {	
	    int block[] = new int[3];
	    for (int i=1;i<9;i++) {
	    	int win1 = array(i);
	    	win= new int[3];
	    	int j=0;
	    	while (win1>0) {
	    		int rem=win1%10;
	    		block[j]=rem;
	    		j++;
	    		win1=win1/10;
	    	}
	    	if (element[block[0]]==element[block[1]]&&element[block[0]]==computerchoice&&element[block[2]]!=userchoice) {
	    	   element[block[2]]=computerchoice;
	    	   System.out.println("My choice is '"+block[2]+"'");
	    	   System.out.println("I won. Better Luck next time");
	    	   System.exit(1);
	       } else if (element[block[0]]==element[block[2]]&&element[block[2]]==computerchoice&&element[block[1]]!=userchoice) {
	    	   element[block[1]]=computerchoice;
	    	   System.out.println("My choice is '"+block[1]+"'");
	    	   System.out.println("I won. Better Luck next time");
	    	   System.exit(1);
	       } else if (element[block[1]]==element[block[2]]&&element[block[2]]==computerchoice&&element[block[0]]!=userchoice) {
	    	   element[block[0]]=computerchoice;
	    	   System.out.println("My choice is '"+block[0]+"'");
	    	   System.out.println("I won. Better Luck next time");
	    	   System.exit(1);
	       }
	    }
	}
	
	/**
	 * @param wincase
	 * @return win sequence number
	 */
	private static int array(int wincase) {
	       if (wincase==1) {
	    	   return 123;
	       } else if (wincase==2) {
	    	   return 456;
	       } else if (wincase==3) {
	    	   return 789;
	       } else if (wincase==4) {
	    	   return 147;
	       } else if (wincase==5) {
	    	   return 258;
	       } else if (wincase==6) {
	    	   return 369;
	       } else if (wincase==7) {
	    	   return 159;
	       } else {
	    	   return 357;
	       }
	}

}