import java.util.*;

public class Caesar {

    static String plainText[];
	static String cipher[];  

    public static void main(Scanner keyboard) {

        System.out.println("Caesar Cipher Encryption");
        System.out.println("Type 'x' to return to the main page");

		// Primary Loop
		while (true) {

			System.out.println("What shift would you like?");
			String answer = keyboard.nextLine();

			// Acquire Key from requested Shift
			if(answer.equalsIgnoreCase("x")){
				return;
			} else {
				setKey(keyboard, answer);
			}

			System.out.println("Would you like to encode or decode?");
			
			// Initiate Encryption/Decryption
			while (true) {
				answer = keyboard.nextLine();
				if(answer.equalsIgnoreCase("encode")) {
					encrypt(keyboard, plainText, cipher);
					break;
				} else if(answer.equalsIgnoreCase("decode")) {
					decrypt(keyboard, plainText, cipher);
					break;
				} else if(answer.equalsIgnoreCase("x")) {
            	    return;
            	} else {
					System.out.println("Invalid Response. Please enter either 'encode' or 'decode'.");
				}
			}
			
			System.out.println("");
			System.out.println("");
		}
    }

	// Finds and sets desired key
	private static void setKey(Scanner keyboard, String answer) {
		while (true) {
			try {
				int answerInt = Integer.parseInt(answer);
				plainText = Ciphers.getCaesarKey(0);
				cipher = Ciphers.getCaesarKey(answerInt);
				break;
			} catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
				System.out.println("Not a valid Shift. Please try using an integer from 0 to 25");
				answer = keyboard.nextLine(); // Easy fix but causes only situation where you cannot exit w/ "x". No additional action required
				continue;
			}
		}	
	}

    // Encryption Logic
	private static void encrypt(Scanner keyboard, String[] plainText, String[] cipher) {
		System.out.println("Plain Text:");
		String userInput = keyboard.nextLine();
		String userInputArray[] = userInput.split("");

		System.out.println("");
		System.out.println("Cipher Text:");

		for (int i = 0; i < userInputArray.length; i++) {
			String letter = userInputArray[i];
			String newLetter;
			int position = Main.findIndex(plainText, letter);
			if (position == -1) {
				newLetter = letter;
			} else {
				newLetter = cipher[position];
			}
			System.out.print(newLetter);
		}
	}
	
	// Decryption Logic
	private static void decrypt(Scanner keyboard, String[] plainText, String[] cipher) {
		System.out.println("Cipher Text:");
		String userInput = keyboard.nextLine();
		String userInputArray[] = userInput.split("");

		System.out.println("");
		System.out.println("Plain Text:");

		for (int i = 0; i < userInputArray.length; i++) {
			String letter = userInputArray[i];
			String newLetter;
			int position = Main.findIndex(cipher, letter);
			if (position == -1) {
				newLetter = letter;
			} else {
				newLetter = plainText[position];
			}
			System.out.print(newLetter);
		}
	}
}
