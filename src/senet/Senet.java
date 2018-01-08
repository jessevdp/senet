package senet;

public class Senet {
	Player[] players;
	Dice dice;
	Board board;

	public Senet() {
		this.dice = new Dice();
		this.players = new Player[2];
		this.board = new Board();
	}
	
	public void play() {
		System.out.println("Let's play Senet!");
		
		// TEST: Dice
		int points = dice.throwSticks();
		System.out.println("Dice throw: " + points);
		
		// TEST: Player
		players[0] = new Player("John", 'x');
		System.out.print("Player print: ");
		players[0].print();
		System.out.print('\n');
		
		// TEST: Board
		System.out.println("Board print:");
		board.print();
	}
}
