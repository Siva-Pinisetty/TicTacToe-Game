package com.bridgelabz.newpackage;
import java.util.*;
public class TicTacToeGame {
	static char[] element;
	static char userchoice,computerchoice;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to  TicTacToe game");
		
		boardLayout();
		
		choosingXorO();
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
}
