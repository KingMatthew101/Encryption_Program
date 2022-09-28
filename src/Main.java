import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.println("Welcome to Matt's Encryption Program!");
			System.out.println("What cipher would you like to use?");
			System.out.println("1 - Caesar Cipher");
			System.out.println("2 - Atbash Cipher");
			String answer = keyboard.nextLine();

			if (answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("Caesar Cipher") || answer.equalsIgnoreCase("Caesar")) {
				try {
					Caesar.main(keyboard);
				} catch (Exception e) {
					throw new RuntimeException("Something went wrong trying to access Caesar.main()");
				}
			} else if (answer.equalsIgnoreCase("2") || answer.equalsIgnoreCase("Atbash Cipher") || answer.equalsIgnoreCase("Atbash")) {
				try {
					Atbash.main(keyboard);
				} catch (Exception e) {
					throw new RuntimeException("Something went wrong trying to access Atbash.main()");
				}
			} else if(answer.equalsIgnoreCase("x")) {
				return;
			} else {
				System.out.println("Invalid Response. Please try typing a cipher's name or their associated number.");
			}
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
