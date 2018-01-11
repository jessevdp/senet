package senet;

import java.util.HashMap;

public class Rules {
	private HashMap<Integer, String> rules;

	public Rules (String message) {
		rules = new HashMap<Integer, String>();
		rules.put(1, "You don't have a pawn on the selected square.");
		rules.put(2, "You can't move past square 30.");
		rules.put(3, "You can't attack a pawn on square 26, 28, or 29.");
		rules.put(4, "You can't jump over 3 enemy pawns in a row.");
		rules.put(5, "One of your own pawns occupies the destination square.");
		rules.put(6, "The destination square contains a safe pawn.");
		rules.put(7, "Not all of your pawns have made it to the final row.");
	}
	
	/**
	 * Check if a move will succeed, returns 0 if it will succeed.
	 * returns the number of the rule it failed on if it won't succeed.
	 * @param player
	 * @param opponent
	 * @param squares
	 * @param from
	 * @param amount
	 * @return failed
	 */
	public int check (Player player, Player opponent, Player[] squares, int from, int amount) {
		if (checkRule1(player, squares, from)) {
			return 1;
		}
		if (checkRule2(from, amount)) {
			return 2;
		}
		if(checkRule3(opponent, squares, from, amount)) {
			return 3;
		}
		if(checkRule4(opponent, squares, from, amount)) {
			return 4;
		}
		return 0;
	}
	
	/* ==================================================
	 * RULE CHECKERS
	 * ================================================== */
	
	/**
	 * Checks rule #1,
	 * returns true if failed
	 * @param player
	 * @param squares
	 * @param location
	 * @return failed
	 */
	private boolean checkRule1 (Player player, Player[] squares, int location) {
		if (squares[location] == player) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks rule #2
	 * returns true if failed
	 * @param from
	 * @param amount
	 * @return failed
	 */
	private boolean checkRule2 (int from, int amount) {
		int dest = from + amount;
		if (dest > (30 - 1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks rule #3
	 * returns true if failed
	 * @param opponent
	 * @param squares
	 * @param from
	 * @param amount
	 * @return failed
	 */
	private boolean checkRule3 (Player opponent, Player[] squares, int from, int amount) {
		int dest = from + amount;
		if (squares[dest] == opponent && (dest == (26 - 1) || dest == (28 - 1) || dest == (29 - 1))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks rule #3
	 * returns true if failed
	 * @param opponent
	 * @param squares
	 * @param from
	 * @param amount
	 * @return failed
	 */
	private boolean checkRule4 (Player opponent, Player[] squares, int from, int amount) {
		int dest = from + amount;
		int enemies = 0;
		for (int i = (from + 1); i < dest; i++) {
			enemies = (squares[i] == opponent) ? (enemies + 1) : 0;
			if (enemies == 3) {
				return true;
			}
		}
		return false;
	}
	
}
