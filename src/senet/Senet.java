package senet;

import java.util.ArrayList;
import java.util.Scanner;

public class Senet {
	Player[] players;
	Dice dice;
	Board board;
	
	Input input = new Input();

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
		int num = dice.throwSticks();
		ArrayList<Integer> pawns = board.getPawnLocations(player);
		
		
		// Announcement
		System.out.println("\n========================================");
		System.out.println("It's " + prefix + " their turn!\n");
		
		// Dice throw
		System.out.print(prefix + ", press <ENTER> to throw the dice");
		input.scanner.nextLine(); // listen for newline
		System.out.println(prefix + ", you have thrown " + num);
		
		System.out.println(prefix + ", which piece do you want to move? " + getPawnLocationsPrint(pawns) );
		int selectedPawn = input.getIntAbove(0) - 1; // -1 since the array starts at 0;
		System.out.println(prefix + ", you selected the piece on square: " + (selectedPawn + 1));
		
		return true;
	}
	
	/**
	 * Get the print for the locations of the pawns
	 * This includes adding 1 to compensate for the 0 based array.
	 * @param pawns
	 * @return print
	 */
	private String getPawnLocationsPrint(ArrayList<Integer> pawns) {
		String print = "";
		for (int i = 0; i < pawns.size(); i++) {
			if (i != 0) {
				print += "-";
			}
			print += pawns.get(i) + 1; // +1 since the array starts at 0
		}
		return "(" + print + ")";
	}
}
