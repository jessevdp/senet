package senet;

public class Output {
	/**
	 * Display a welcome message
	 */
	public void intro () {
		System.out.println("Welcome, let's play some Senet!");
		System.out.println("-------------------------------");
	}
	
	/**
	 * Display a turn notice for a player
	 * @param player
	 */
	public void turn (Player player) {
		String print = player.getPrint();
		
		System.out.println('\n' + "========================================");
		System.out.println("It's " + print + " their turn!");
	}
	
	/**
	 * Announces the winner of a game
	 * @param player
	 */
	public void winner (Player player) {
		String print = player.getPrint();
		
		System.out.println('\n' + "****************************************");
		System.out.println(print + " won the game!");
		System.out.println("****************************************");
	}
}
