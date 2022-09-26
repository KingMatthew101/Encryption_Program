import java.util.*;

public class Caesar {
        
    public static void main(Scanner keyboard) {
        // String plainKey = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
	    // String plainText[] = plainKey.split(" ");
	    // String cipherKey = "b c d e f g h i j k l m n o p q r s t u v w x y z a";
	    // String cipher[] = cipherKey.split(" "); 
		
        /* 
        TODO: expand this code. Create separate file holding all Caesar keys and
        connect back to this file so that you can choose what Shift to use
        */ 

		/*
		TODO: Refactor code to be more readable. Extract the "Acquire Key" loop into a separate method
		Also consider extracting Encryption/Decryption Initiation into a new method
		*/

        System.out.println("Caesar Cipher Encryption");
        System.out.println("Type 'x' to return to the main page");

		// Primary Loop
		while (true) {
			System.out.println("What shift would you like?");
			String plainText[];
			String cipher[];

			// Acquire Key from requested Shift
			while (true) {
				String answer = keyboard.nextLine();
				if(answer.equalsIgnoreCase("x")){
					return;
				} else {
					try {
						int answerInt = Integer.parseInt(answer);
						plainText = Ciphers.getCaesarKey(0);
						cipher = Ciphers.getCaesarKey(answerInt);
						break;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Not a valid Shift. Please try again.");
						continue;
					}
				}
			}

			System.out.println("Would you like to encode or decode?");
			String answer = keyboard.nextLine();
			
			// Initiate Encryption/Decryption
			if(answer.equalsIgnoreCase("encode")) {
				encrypt(keyboard, plainText, cipher);
			} else if(answer.equalsIgnoreCase("decode")) {
				decrypt(keyboard, plainText, cipher);
			} else if(answer.equalsIgnoreCase("x")) {
                return;
            } else {
				System.out.println("Invalid Response");
			}
			
			System.out.println("");
			System.out.println("");
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
