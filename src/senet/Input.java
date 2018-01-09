package senet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}
	
	public int getPositiveInt() {
		int i = -1;
		while (i < 0) {
			try {
				i = scanner.nextInt();
			} catch (InputMismatchException ime) {
				System.out.print("That's not a number, try again? : ");
				scanner.nextLine(); // Clear the keyboard buffer
			}
		}
		return i;
	}

}
