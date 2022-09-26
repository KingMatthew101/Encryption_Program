import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		while (true) {
			System.out.println("Welcome to Matt's Encryption Program!");
			System.out.println("What cipher would you like to use?");
			System.out.println("1 - Caesar Cipher");
			String answer = keyboard.nextLine();

			if (answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("Caesar Cipher") || answer.equalsIgnoreCase("Caesar")) {
				try {
					Caesar.main(keyboard);
				} catch (Exception e) {
					throw new RuntimeException("Something went wrong trying to access Caesar.main()");
				}
			} else if(answer.equalsIgnoreCase("x")) {
				return;
			} else {
				System.out.println("Invalid Response");
			}
		}
	}
}
