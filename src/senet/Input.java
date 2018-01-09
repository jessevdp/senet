package senet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}
	
	public int getInt() {
		int i;
		while (true) {
			try {
				System.out.print("Enter a number : ");
				i = scanner.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("Oeps, that's not a number... Try again?");
				scanner.nextLine(); // Clear the keyboard buffer
				continue;
			}
			break;
		}
		return i;
	}
}
