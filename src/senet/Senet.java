package senet;

import java.util.ArrayList;
import java.util.Scanner;

public class Senet {
	Player[] players;
	Dice dice;
	Board board;
	
	Scanner scanner = new Scanner(System.in);

	public Senet() {
		this.dice = new Dice();
		this.players = new Player[2];
	}
	
	public void play() {
		System.out.println("Let's play Senet!");
		
		// TEST: Dice
		int points = dice.throwSticks();
		System.out.println("Dice throw: " + points);
		
		// TEST: Player
		players[0] = new Player("John", 'x');
		players[1] = new Player("Jane", 'o');
		System.out.println("Player print: " + players[0].getPrint());
		
		// TEST: Board
		this.board = new Board(0, players[0], players[1]);
		System.out.println("Board print:");
		board.print();
		
		// TEST Board.countPawns
		int count = board.countPawns(players[0]);
		System.out.println("Amount of pawns for player 1: " + count);
		
		// TEST: Board.getPawnLocations
		ArrayList<Integer> locations = board.getPawnLocations(players[0]);
		System.out.println("Locations of pawns for player 1: " + locations.toString() + " (this is 0 based)");
		
		// TEST: this.playTurn()
		boolean success = playTurn(players[0]);
	}
	
	/**
	 * Play a turn with a certain player
	 * @param player
	 * @return success status of the turn
	 */
	private boolean playTurn(Player player) {
		String prefix = player.getPrint();
		System.out.println("\n========================================");
		System.out.println("It's " + prefix + " their turn!\n");
		
		// Dice throw
		System.out.print(prefix + ", press <ENTER> to throw the dice");
		scanner.nextLine(); // listen for newline
		int num = dice.throwSticks();
		System.out.println(prefix + ", you have thrown " + num);
		
		return true;
	}
}
