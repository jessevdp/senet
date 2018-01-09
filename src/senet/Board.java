package senet;

import java.util.ArrayList;

public class Board {
	private Player[] squares;
	
	public Board(int num, Player b, Player w) {
		switch (num) {
		case 1:
			this.squares = new Player[]{b,w,null,w,null,w,null,b,null,w, null,w,null,w,null,b,w,w,null,w, w,null,b,w,w,w,null,null,null,null};
			break;
		case 2:
			this.squares = new Player[]{null,null,null,null,null,null,null,null,null,null, null,null,null,null,null,null,null,null,null,null, null,w,w,w,null,null,null,null,b,null};
			break;
		case 3:
			this.squares = new Player[]{null,null,null,null,null,w,null,null,null,null, null,null,b,null,null,null,null,w,null,null, null,w,null,null,b,b,null,b,b,null};
			break;
		default:
			this.squares = new Player[]{w,b,w,b,w,b,w,b,w,null, b,null,null,null,null,null,null,null,null,null, null,null,null,null,null,null,null,null,null,null};
			break;
		}
	}
	
	public void print() {
		System.out.println("+----------+");
		
		System.out.print('|');
		for (int i = 0; i < 10; i++) {
			printSquare(squares[i]);
		}
		System.out.print("|\n");
		
		System.out.print('|');
		for (int i = 19; i > 9; i--) {
			printSquare(squares[i]);
		}
		System.out.print("|\n");
		
		System.out.print('|');
		for (int i = 20; i < 30; i++) {
			printSquare(squares[i]);
		}
		System.out.print("|\n");
		
		System.out.println("+----------+");
	}
	
	private void printSquare(Player square) {
		if (square == null) {
			System.out.print('\u00b7');
			return;
		}
		char character = square.getColorsign();
		System.out.print(character);
	}
	
	/**
	 * Counts the amount of pawns a player has on the board
	 * @param player
	 * @return count
	 */
	public int countPawns(Player player) {
		int count = 0;
		for (int i = 0; i < squares.length; i++) {
			if(squares[i] == player) {
				count += 1;
			}
		}
		return count;
	}
	
	/**
	 * Get the locations of the pawns of a player
	 * @param player
	 * @return A list with the locations
	 */
	public ArrayList<Integer> getPawnLocations(Player player) {
		ArrayList<Integer> locations = new ArrayList<Integer>();
		for (int i = 0; i < squares.length; i++) {
			if(squares[i] == player) {
				locations.add(i);
			}
		}
		return locations;
	}
	
	/**
	 * Move the pawn on a given location a certain amount of pawns
	 * @param location
	 * @param amount
	 * @param player
	 * @return success status of the move
	 */
	public boolean move(int location, int amount, Player player) {
		int dest = location + amount;
		
		if (dest > (squares.length - 1)) { // -1 to compensate for the fact that the array is 0 based
			System.out.println("\nOeps, not possible. That move would go off the board...");
			return false;
		}
		
		Player destination = squares[dest];
		
		if (destination == player) {
			System.out.println("\nOeps, not possible. One of your own pawns occupies square " + dest + "...");
			return false;
		}
		
		if (dest == (squares.length - 1) // -1 to compensate for the fact that the array is 0 based
				&& !allPawnsInLastRow(player)) {
			System.out.println("\nOeps, not possible. Not all of your pawns have made it to the final row yet...");
			return false;
		}
		
		if (dest == (squares.length - 1)) { // -1 to compensate for the fact that the array is 0 based
			squares[location] = null;
			return true;
		}
		
		// Swap the destination with the current location
		Player occupant = squares[dest];
		squares[dest] = player;
		squares[location] = occupant;
		return true;
	}
	
	private boolean allPawnsInLastRow(Player player) {
		ArrayList<Integer> pawns = getPawnLocations(player);
		int first = pawns.get(0);
		if (first > 19) {
			return true;
		}
		return false;
	}
}
