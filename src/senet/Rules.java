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
		return 0;
	}
	
	/* ==================================================
	 * RULE CHECKERS
	 * ================================================== */
	
	/**
	 * Checks rule # 1,
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
	
}
