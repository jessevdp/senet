package senet;

public class Board {
	private Player[] squares;
	
	public Board(int n, Player b, Player w) {
		switch (n) {
		case 1:
			this.squares = new Player[]{b,w,null,w,null,w,null,b,null,w, null,w,null,w,null,b,w,w,null,w, w,null,b,w,w,w,null,null,null,null};
			break;
		case 2:
			this.squares = new Player[]{null,null,null,null,null,null,null,null,null,null, null,null,null,null,null,null,null,null,null,null, null,w,w,w,null,null,null,null,b,null};
			break;
		case 3:
			this.squares = new Player[]{null,null,null,null,null,w,null,null,null,null, null,null,b,null,null,null,null,w,null,null, null,w,null,null,b,b,null,b,b,null};
			break;
		default:
			this.squares = new Player[]{w,b,w,b,w,b,w,b,w,null, b,null,null,null,null,null,null,null,null,null, null,null,null,null,null,null,null,null,null,null};
			break;
		}
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
