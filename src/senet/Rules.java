package senet;

import java.util.ArrayList;
import java.util.HashMap;

public class Rules {
	private HashMap<Integer, String> rules;

	public Rules () {
		rules = new HashMap<Integer, String>();
		rules.put(1, "You don't have a pawn on the selected square.");
		rules.put(2, "You can't move off the board.");
		rules.put(3, "You can't attack a pawn on square 26, 28, or 29.");
		rules.put(4, "You can't jump over 3 enemy pawns in a row.");
		rules.put(5, "One of your own pawns occupies the destination square.");
		rules.put(6, "The destination square contains a safe pawn.");
		rules.put(7, "Not all of your pawns have made it to the final row.");
	}
	
	/**
	 * Get a rule by it's number
	 * @param n
	 * @return rule
	 */
	public String get (int n) {
		return rules.get(n);
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
		if (checkRule5(player, squares, from, amount)) {
			return 5;
		}
		if (checkRule6(opponent, squares, from, amount)) {
			return 6;
		}
		if (checkRule7(player, squares, from, amount)) {
			return 7;
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
		if (dest > (30 - 1) || (dest < 0)) {
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
	 * Checks rule #4
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
		int n = (amount > 0) ? 1 : -1;
		for (int i = (from + n); i < dest; i += n) {
			enemies = (squares[i] == opponent) ? (enemies + 1) : 0;
			if (enemies == 3) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks rule #5
	 * returns true if failed
	 * @param player
	 * @param squares
	 * @param from
	 * @param amount
	 * @return failed
	 */
	private boolean checkRule5 (Player player, Player[] squares, int from, int amount) {
		int dest = from + amount;
		if (squares[dest] == player) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks rule #6
	 * returns true if failed
	 * @param opponent
	 * @param squares
	 * @param from
	 * @param amount
	 * @return failed
	 */
	private boolean checkRule6 (Player opponent, Player[] squares, int from, int amount) {
		int dest = from + amount;
		Player destination = squares[dest];
		Player before = (dest == (1 - 1)) ? null : squares[dest - 1];
		Player after = (dest == (30 - 1)) ? null : squares[dest + 1];
		if (destination == opponent && (before == opponent || after == opponent)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks rule #7
	 * returns true if failed
	 * @param player
	 * @param squares
	 * @return failed
	 */
	private boolean checkRule7 (Player player, Player[] squares, int from, int amount) {
		int dest = from + amount;
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		if (!(dest == (30 - 1))) {
			return false;
		}
		
		for (int i = 0; i < squares.length; i++) {
			if (squares[i] == player) {
				positions.add(i);
			}
		}
		if (positions.get(0) > 19) {
			return false;
		}
		return true;
	}
}
