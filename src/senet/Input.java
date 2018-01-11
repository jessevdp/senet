package senet;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * Prompt the user to select an integer from an array of options
	 * @param options
	 * @param message
	 * @return selected integer
	 */
	public int selectInt (int[] options, String message) {
		int i;
		String question = "Choose a number " + getOptionsPrint(options) +" : ";
		
		System.out.println('\n' + message);
		
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
	
	/**
	 * Prompt the user to confirm a message by pressing <ENTER>
	 * @param message
	 */
	public void confirm (String message) {
		System.out.println('\n' + message);
		
		System.out.print("Press <ENTER> ");
		scanner.nextLine();
	}
	
	/* ==================================================
	 * HELPER FUNCTIONS
	 * ================================================== */
	
	/**
	 * Get a printable string based on a list of options
	 * @param options
	 * @return print
	 */
	private String getOptionsPrint (int[] options) {
		String print = "";
		for (int i = 0; i < options.length; i++) {
			print += (i == 0) ? options[i] : "-" + options[i];
		}
		return "(" + print + ")";
	}
}
