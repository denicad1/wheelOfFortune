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
	final static Scanner key = new Scanner(System.in);

	/*
	 * this counter is only for saying which player is getting named
	 */
	/** I couldn't get it to cover the input as people enter it */
	static int rounds = 3;

	public static void main(String[] args) {

		wheel.add(-1);// lose a turn
		wheel.add(800);
		wheel.add(350);
		wheel.add(450);
		wheel.add(700);

		wheel.add(300);
		wheel.add(600);
		wheel.add(5000);
		wheel.add(300);
		wheel.add(600);
		wheel.add(300);
		wheel.add(500);
		wheel.add(800);
		wheel.add(550);
		wheel.add(400);
		wheel.add(300);
		wheel.add(900);
		wheel.add(500);
		wheel.add(300);// wildcard. this should be wildcard but i was gonna get that later
		wheel.add(900);
		wheel.add(0);// bankrupt
		wheel.add(600);
		wheel.add(400);
		wheel.add(300);
		System.out.println("Welcome to Wheel of Fortune");
		/* these are the players */
		player player1 = new player(0, 0, Name());
		player player2 = new player(0, 0, Name());
		player player3 = new player(0, 0, Name());
		/* adding the player objects to the array listOfPlayers */
		listOfPlayers.add(player1);
		listOfPlayers.add(player2);
		listOfPlayers.add(player3);

		/* figure out a free spin system */

		for (int i = 0; i < 4; i++) {
			board(topic());
			do {
				if (playerturn == 3) {
					playerturn = 0;
				}
				choices(key);

			} while (finished != true);
			listOfPlayers.get(playerturn).isSolved();
			for (int j = 0; j < listOfPlayers.size(); j++) {
				System.out.println("Here is " + listOfPlayers.get(j).getName() + " grand total: "
						+ listOfPlayers.get(j).grandTotalBank);
			}
		}
		player winner = listOfPlayers.get(0);
		for (int i = 0; i < listOfPlayers.size(); i++) {

			if (winner.grandTotalBank < listOfPlayers.get(i).grandTotalBank) {
				winner = listOfPlayers.get(i);
			}

		}
		System.out.println(winner.getName().toString() + " is the winner with " + winner.grandTotalBank + " dollars!");

		key.close();

	}

	/*
	 * the name method allows you to name each player
	 */
	public static String Name() {
		// you can enter a blank name
		System.out.println("input player" + counter + " name");
		String name = key.nextLine();

		counter++;
		return name;

	}

	/*
	 * the choices method allows you to choose between picking a vowel, consonant or
	 * attempting to solve the puzzle
	 */
	public static void choices(Scanner number) {
		try {
			System.out.println("what would you like to do " + listOfPlayers.get(playerturn).getName()
					+ "? Press 1 to buy a vowel, " + "press 2 to get a consonant " + "press 3 to solve the puzzle ");

			int caseNumber = Integer.parseInt(number.nextLine());

			switch (caseNumber) {
			case 1: {

				boolean durp = listOfPlayers.get(playerturn).chooseVowel(key);
				if (durp == false) {
					playerturn++;
				}
				break;

			}
			case 2: {
				boolean durp = listOfPlayers.get(playerturn).chooseConsonant(key);

				if (durp == false) {
					playerturn++;
				}
				break;

			}
			case 3: {
				finished = listOfPlayers.get(playerturn).solve(key);

				break;

			}

			}
		} catch (NumberFormatException e) {
			System.out.println("not a correct input");
			// TODO: handle exception
		}
	}
}
