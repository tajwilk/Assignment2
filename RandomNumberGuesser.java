import java.util.Scanner;

public class RandomNumberGuesser {
	public static void main(String[] args) {
		
		System.out.println("This is a random number guessing game.");
		
		Scanner stdin = new Scanner(System.in);
		String answer;
		boolean inputInBounds;
		do {
			int randNum = RNG.rand();
			int nextGuess = -1;
			int highGuess = 100;
			int lowGuess = 0;
			RNG.resetCount();
			while(nextGuess != randNum) { 
				inputInBounds = false;
				System.out.println("Number of guesses is " + RNG.getCount());
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess + ".");
				
				while(!inputInBounds) {
					nextGuess = stdin.nextInt();
					stdin.nextLine();
					inputInBounds = RNG.inputValidation(nextGuess, lowGuess, highGuess);
				}
				
				if(nextGuess > randNum) {
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				} else if(nextGuess < randNum) {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				
			}
			System.out.println("Congratulations, you guessed correctly");
			System.out.println("Try again? (yes/no) ");
			answer = stdin.nextLine();
		} while(answer.equals("yes"));
		
	}
}
