package senet;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}
	
	public int selectInt (int[] options) {
		int i;
		String question = "Choose a number " + getOptionsPrint(options) +" : ";
		
		while (true) {
			try {
				System.out.print(question);
				i = scanner.nextInt();
				if (Arrays.binarySearch(options, i) > -1) {
					scanner.nextLine(); // Clear the keyboard buffer
					return i;
				}
			} catch (InputMismatchException ime) {
				scanner.nextLine(); // Clear the keyboard buffer
			}
			System.out.println("Oeps, that's not an option... Try again?");
		}
	}
	
	private String getOptionsPrint (int[] options) {
		String print = "";
		for (int i = 0; i < options.length; i++) {
			print += (i == 0) ? options[i] : "-" + options[i];
		}
		return "(" + print + ")";
	}
}
