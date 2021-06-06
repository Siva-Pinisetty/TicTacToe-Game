package com.bridgelabz.newpackage;

public class TicTacToeGame {
	static char[] element;
	
	public static void main(String[] args) {
		System.out.println("Welcome to  TicTacToe game");
		
		boardLayout();
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
}
