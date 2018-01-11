package senet;

import java.util.ArrayList;

public class Board {
	private Player[] squares;
	
	public Board (int n, Player b, Player w) {
		switch (n) {
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
	
	/**
	 * Print the board
	 */
	public void print () {
		System.out.println('\n' + "+----------+");
		
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
	
	/**
	 * Prints the character representation of a square
	 * (helper for print)
	 * @param square
	 */
	private void printSquare (Player square) {
		if (square == null) {
			System.out.print('\u00b7');
			return;
		}
		char character = square.getColorsign();
		System.out.print(character);
	}
	
	/**
	 * Get the locations for all the pawns of a player
	 * @param player
	 * @return positions
	 */
	public int[] getPawnPositions (Player player) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] positions;
		
		for (int i = 0; i < squares.length; i++) {
			if (squares[i] == player) {
				list.add(i + 1); // +1 to make up for the fact that the array is 0 based
			}
		}
		
		// ArrayList<Integer> -> int[]
		positions = new int[list.size()];
		for (int i = 0; i < positions.length; i++) {
			positions[i] = list.get(i).intValue();
		}
		
		return positions;
	}
	
}
