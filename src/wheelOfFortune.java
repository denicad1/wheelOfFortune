import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */
/**
 * @author Anthony Denicolo
 *
 */
public class wheelOfFortune extends Setup {
	final static Scanner key = new Scanner(System.in);// don't forget to close scanner
	static int playerturn = 0;
	/*
	 * this counter is only for saying which player is getting named
	 */
	static int counter = 1;
	static int rounds = 3;
	/* array of players */

	public static void main(String[] args) {

		System.out.println("Welcome to Wheel of Fortune");
		/* these are the players */
		player player1 = new player(100, 0, Name());
		player player2 = new player(100, 0, Name());
		player player3 = new player(100, 0, Name());
		/* adding the player objects to the array listOfPlayers */
		listOfPlayers.add(player1);
		listOfPlayers.add(player2);
		listOfPlayers.add(player3);
		board(topic());
		String durp = choices(key);
		for (int i = 0; i < rounds; i++) {

			listOfPlayers.get(playerturn).boardchanger(durp);
			playerturn++;
		}

		key.close();

	}

	/*
	 * the name method allows you to name each player
	 */
	public static String Name() {

		System.out.println("input player" + counter + " name");
		String name = key.nextLine();
		counter++;
		return name;

	}

	/*
	 * the choices method allows you to choose between picking a vowel, consonant or
	 * attempting to solve the puzzle
	 */
	public static String choices(Scanner number) {
		/*
		 * this for loop is for choosing which player is getting to choose what they
		 * want to do
		 */
		try {
			System.out.println("what would you like to do " + listOfPlayers.get(playerturn).getName()
					+ "? Press 1 to buy a vowel, " + "press 2 to get a consonant " + "press 3 to solve the puzzle ");
			int caseNumber = number.nextInt();

			switch (caseNumber) {
			case 1: {
				return listOfPlayers.get(playerturn).chooseVowel(key);

			}
			case 2: {
				return listOfPlayers.get(playerturn).chooseConsonant(key);

			}
			case 3: {
				return listOfPlayers.get(playerturn).solve(key);

			}
			}

		} catch (Exception e) {
			number.next();
			// TODO: handle exception
		}
		return null;

	}

	/*
	 * method to take input from return value from choices and check to make sure
	 * that it produces something of value
	 */
	public static void turn(String fill) {

		System.out.println(playerturn);
		if (playerturn > 2) {
			playerturn = 0;
		}
	}

}
