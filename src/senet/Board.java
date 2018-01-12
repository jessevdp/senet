package senet;

import java.util.ArrayList;

public class Board {
	private Player[] squares;
	private ArrayList<Player[]> boards;
	private Rules rules;
	
	public Board (int n, Player b, Player w) {
		boards = new ArrayList<Player[]>();
		boards.add(0, new Player[]{w,b,w,b,w,b,w,b,w,null, b,null,null,null,null,null,null,null,null,null, null,null,null,null,null,null,null,null,null,null});
		boards.add(1, new Player[]{b,w,null,w,null,w,null,b,null,w, null,w,null,w,null,b,w,w,null,w, w,null,b,w,w,w,null,null,null,null});
		boards.add(2, new Player[]{null,null,null,null,null,null,null,null,null,null, null,null,null,null,null,null,null,null,null,null, null,w,w,w,null,null,null,null,b,null});
		boards.add(3, new Player[]{null,null,null,null,null,w,null,null,null,null, null,null,b,null,null,null,null,w,null,null, null,w,null,null,b,b,null,b,b,null});
		
		squares = boards.get(n);
		
		rules = new Rules();
	}
	
	/**
	 * Get the different options for the boards
	 * @return boards
	 */
	public int[] getOptions () {
		int[] boards = new int[this.boards.size()];
		for (int i = 0; i < boards.length; i++) {
			boards[i] = i;
		}
		return boards;
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
	
	/**
	 * Get the locations of the pawns that can be moved
	 * @param player
	 * @param opponent
	 * @param amount
	 * @return locations
	 */
	public int[] getMoves (Player player, Player opponent, int amount) {
		int [] positions = getPawnPositions(player);
		int [] options;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<String> errors = new ArrayList<String>();
		
		for (int i = 0; i < positions.length; i++) {
			int location = positions[i] - 1;
			int result = rules.check(player, opponent, squares, location, amount);
			if (result == 0) {
				list.add(positions[i]);
			} else {
				errors.add(positions[i] + ": " + rules.get(result));
			}
		}
		
		// Report pawns that can't be moved
		if (errors.size() > 0) {
			System.out.println('\n' + player.getPrint() + ", the following pawns can't be moved:");
			for (String string : errors) {
				System.out.println(string);
			}
		}
		
		// ArrayList<Integer> -> int[]
		options = new int[list.size()];
		for (int i = 0; i < options.length; i++) {
			options[i] = list.get(i).intValue();
		}
		return options;
	}
	
	/**
	 * Move the pawn on a location an amount of squares
	 * @param player
	 * @param opponent
	 * @param location
	 * @param amount
	 * @return success
	 */
	public boolean move (Player player, Player opponent, int location, int amount) {
		location = location - 1;
		int dest = location + amount;
		int result = rules.check(player, opponent, squares, location, amount);
		if (result != 0) {
			return false;
		}
		
		if (dest == (30 - 1)) {
			squares[location] = null;
		} else if (dest == (27 - 1)) {
			System.out.println("\nTrapdoor! Sending this pawn back to the beginning...");
			int i = 0;
			while (true) {
				if (i == squares.length) {
					return false;
				}
				if (squares[i] == null) {
					squares[i] = player;
					squares[location] = null;
					break;
				}
				i += 1;
			}
		} else {
			Player occupant = squares[dest];
			squares[dest] = player;
			squares[location] = occupant;
		}
		print();
		return true;
	}
}
