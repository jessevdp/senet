package senet;

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
		System.out.print("Player print: ");
		players[0].print();
		System.out.print('\n');
		
		// TEST: Board
		this.board = new Board(0, players[0], players[1]);
		System.out.println("Board print:");
		board.print();
	}
}
