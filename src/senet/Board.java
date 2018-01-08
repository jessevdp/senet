package senet;

public class Board {
	private Player[] squares;
	
	public Board(Player[] squares) {
		this.squares = squares;
	}
	
	public Board() {
		this.squares = new Player[30];
	}
	
	public void print() {
		System.out.println("+----------+");
		
		System.out.print('|');
		for (int i = 0; i < 10; i++) {
			printSquare(squares[i]);
		}
		System.out.print("|\n");
		
		System.out.print('|');
		for (int i = 19; i > 9; i--) {
			printSquare(squares[i]);
		}
		System.out.print("|\n");
		
		System.out.print('|');
		for (int i = 20; i < 30; i++) {
			printSquare(squares[i]);
		}
		System.out.print("|\n");
		
		System.out.println("+----------+");
	}
	
	private void printSquare(Player square) {
		if (square == null) {
			System.out.print('\u00b7');
			return;
		}
		char character = square.getColorsign();
		System.out.print(character);
	}
}
