package senet;

public class Senet {
	Dice dice;
	Board board;
	Player[] players;
	Player winner;
	
	Input input;
	Output output;

	public Senet () {
		this.dice = new Dice();
		this.players = new Player[2];
		
		this.input = new Input();
		this.output = new Output();
	}
	
	/**
	 * Play a game of Senet
	 */
	public void play () {
		int current = 1;
		
		output.intro();
		
		int mode = input.selectInt(new int[] {0, 1, 2, 3}, "Before we begin: Would you like to start a normal game (0) or a test position?");
		
		if (mode == 0) {
			String[] names = input.getNames(players.length);
			players = determineStarter(names);
		} else {
			players[0] = new Player("John", 'x');
			players[1] = new Player("Jane", 'o');
		}
		
		board = new Board(mode, players[0], players[1]);
		board.print();
		
		while (winner == null) {
			current ^= 1;
			Player player = players[current];
			Player oppenent = players[(current ^ 1)]; // XOR (^) to select the other player
			
			playTurn(player, oppenent);
			
			winner = player; // TODO: remove this (meant to stop infinite loop)
		}
		
		output.winner(winner);
	}
	
	/**
	 * Play a turn
	 * @param player
	 * @param opponent
	 */
	public void playTurn (Player player, Player opponent) {
		int[] pawns = board.getPawnPositions(player);
		
		if (pawns.length == 0) {
			return;
		}
		
		output.turn(player);
	}
	
	/* ==================================================
	 * HELPER FUNCTIONS
	 * ================================================== */
	
	/**
	 * Determine the starter of a game
	 * @param names
	 * @return players (first player in the array starts)
	 */
	public Player[] determineStarter (String[] names) {
		int player = 0;
		Player[] players = new Player[2];
		
		System.out.println(); // blank line
		while (true) {
			int n = dice.throwSticks();
			System.out.println(names[player] + " has thrown " + n);
			if (n == 1) {
				break;
			}
			player ^= 1; // XOR switch
		}
		System.out.println('\n' + names[player] + " starts the game!");
		players[0] = new Player(names[player], 'x');
		players[1] = new Player(names[(player ^ 1)], 'o'); // XOR (^) to select the other name
		return players;
	}
	
}
