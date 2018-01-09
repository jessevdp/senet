package senet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}
	
	public int getIntAbove(int num) {
		int i = num;
		while (i < (num + 1)) {
			try {
				System.out.print("Enter a number : ");
				i = scanner.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("Oeps, that's not a number... Try again?");
				scanner.nextLine(); // Clear the keyboard buffer
				continue;
			}
			if (i < (num + 1)) {
				System.out.println("Oeps, that's not high enough... Try again?");
			}
		}
		return i;
	}
}
