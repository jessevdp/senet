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
	 * (optionally add a message to display beforehand)
	 * @param options
	 * @param message
	 * @return selected integer
	 */
	public int selectInt (int[] options, String message) {
		int i;
		String question = "Choose a number " + getOptionsPrint(options) +" : ";
		
		if (message.length() > 0) {
			System.out.println('\n' + message);
		}
		
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
	
	public int selectInt(int[] options) {
		return selectInt(options, "");
	}
	
	/**
	 * Prompt the user to confirm a message by pressing <ENTER>
	 * (optionally add a message to display beforehand)
	 * @param message
	 */
	public void confirm (String message) {
		if (message.length() > 0) {
			System.out.println('\n' + message);
		}
		
		System.out.print("Press <ENTER> ");
		scanner.nextLine();
	}
	
	public void confirm () {
		confirm("");
	}
	
	/**
	 * Get the names of a variable amount of players
	 * @param amount
	 * @return names
	 */
	public String[] getNames(int amount) {
		String[] names = new String[amount];
		System.out.println(); // blank line
		for (int i = 0; i < names.length; i++) {
			String suffix = (i == 0) ? "st" : "th";
			System.out.print("Enter the name of the " + (i + 1) + suffix + " player : ");
			names[i] = scanner.next();
		}
		return names;
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
