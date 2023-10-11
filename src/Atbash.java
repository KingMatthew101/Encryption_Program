import java.util.*;

public class Atbash {

    public static void main(Scanner keyboard) {
        String[] cipher = Ciphers.getAtbashKey();

        System.out.println("Atbash Cipher Encryption");
        System.out.println("Type 'x' to return to the main page");

		// Primary Loop
		while (true) {

			System.out.println("Would you like to encode or decode?");
			String answer = keyboard.nextLine();
			
			// Initiate Encryption/Decryption
			while (true) {
				if(answer.equalsIgnoreCase("encode")) {
					encrypt(keyboard, cipher);
					break;
				} else if(answer.equalsIgnoreCase("decode")) {
					decrypt(keyboard, cipher);
					break;
				} else if(answer.equalsIgnoreCase("x")) {
            	    return;
            	} else {
					System.out.println("Invalid Response. Please enter either 'encode' or 'decode'.");
					break;
				}
			}
			
			System.out.println("");
			System.out.println("");
		}
    }

    // Encryption Logic
	private static void encrypt(Scanner keyboard, String[] key) {
		System.out.println("Plain Text:");
		String userInput = keyboard.nextLine();
		String userInputArray[] = userInput.split("");

		System.out.println("");
		System.out.println("Cipher Text:");

		for (int i = 0; i < userInputArray.length; i++) {
			String letter = userInputArray[i];
			String newLetter;
			int position = Main.findIndex(key, letter);
			if (position == -1) {
				newLetter = letter;
			} else {
                position = 25 - position;
				newLetter = key[position];
			}
			System.out.print(newLetter);
		}
	}
	
	// Decryption Logic
	private static void decrypt(Scanner keyboard, String[] key) {
		System.out.println("Cipher Text:");
		String userInput = keyboard.nextLine();
		String userInputArray[] = userInput.split("");

		System.out.println("");
		System.out.println("Plain Text:");

		for (int i = 0; i < userInputArray.length; i++) {
			String letter = userInputArray[i];
			String newLetter;
			int position = Main.findIndex(key, letter);
			if (position == -1) {
				newLetter = letter;
			} else {
                position = 25 - position;
				newLetter = key[position];
			}
			System.out.print(newLetter);
		}
	}
}
