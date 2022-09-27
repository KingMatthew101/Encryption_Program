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

			// Acquire Key from requested Shift
			setKey(keyboard);

			System.out.println("Would you like to encode or decode?");
			String answer = keyboard.nextLine();
			
			// Initiate Encryption/Decryption
			while (true) {
				if(answer.equalsIgnoreCase("encode")) {
					encrypt(keyboard, plainText, cipher);
					break;
				} else if(answer.equalsIgnoreCase("decode")) {
					decrypt(keyboard, plainText, cipher);
					break;
				} else if(answer.equalsIgnoreCase("x")) {
            	    return;
            	} else {
					System.out.println("Invalid Response. Please try again.");
				}
			}
			
			System.out.println("");
			System.out.println("");
		}
    }

	// Finds and sets desired key
	private static void setKey(Scanner keyboard) {
		while (true) {
			String answer = keyboard.nextLine();
			if(answer.equalsIgnoreCase("x")){
				return; // TODO: Find way for this return statement to return out of Caesar.main() as well and not just setKey()
			} else {
				try {
					int answerInt = Integer.parseInt(answer);
					plainText = Ciphers.getCaesarKey(0);
					cipher = Ciphers.getCaesarKey(answerInt);
					break;
				} catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
					System.out.println("Not a valid Shift. Please try again.");
					continue;
				}
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
			int position = findIndex(plainText, letter);
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
			int position = findIndex(cipher, letter);
			if (position == -1) {
				newLetter = letter;
			} else {
				newLetter = plainText[position];
			}
			System.out.print(newLetter);
		}
	}

	// Linear-search function to find the index of an element
    public static int findIndex(String array[], String letter)
    {
  
        // if array is Null
        if (array == null) {
            return -1;
        }
  
        // find length of array
        int arrayLength = array.length;
        int i = 0;
  
        // traverse in the array
        while (i < arrayLength) {
        	
            // if the i-th element is letter
            // then return the index
            if (array[i].equalsIgnoreCase(letter)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
	// Credit to GeeksforGeeks.org @ https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
}
