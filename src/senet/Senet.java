package senet;

import java.util.ArrayList;

public class Senet {
	Player[] players;
	Dice dice;
	Board board;

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
		playTurn(players[0]);
	}
	
	/**
	 * Play a turn with a certain player
	 * @param player
	 * @return success status of the turn
	 */
	private boolean playTurn(Player player) {
		System.out.println("\n========================================");
		System.out.print("It's " + player.getPrint() + " their turn!\n");
		
		return true;
	}
}
