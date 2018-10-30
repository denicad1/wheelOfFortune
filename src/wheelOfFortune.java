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

	/*
	 * this counter is only for saying which player is getting named
	 */

	static int rounds = 3;
	/* array of players */

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
		wheel.add(2);// wildcard
		wheel.add(900);
		wheel.add(0);// bankrupt
		wheel.add(600);
		wheel.add(400);
		wheel.add(300);
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

		/*
		 * figure out how to make it run correctly. the solve method isnt working
		 * properly. I believe that the chooseVowel and ChooseConsonant work properly.
		 * just gotta put those parts together first
		 */
		/* still have to add a multiplier for when multiple letters are correct */
		/* still have to add a banking system */
		/*
		 * make sure that when choosing a vowel, it deducts a 100 points and that if
		 * they dont have enough that it will tell them
		 */
		/* figure out a free spin system */
		for (int i = 0; i < 10; i++) {

			do {
				choices(key);

			} while (isSolved(billboard, word) == false);
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

				System.out.println(durp + " this is after turn method");

				if (durp == false) {
					playerturn++;
				}
				break;

			}
			case 3: {
				String durp = listOfPlayers.get(playerturn).solve(key);
				// boardchanger(durp);
				// System.out.println(durp);
				isSolved(billboard, word);

				break;

			}

			}
		} catch (Exception e) {
			number.nextLine();
			// TODO: handle exception
		}

	}

	public static void boardchanger(String x) {

		for (int i = 0; i < billboard.size(); i++) {

			if (billboard.get(i).equals(x)) {
				word.replace(i, i + 1, x);
			}

		}

		System.out.println(billboard.toString() + "this is from the boardchanger method");
		System.out.println(word + "same as above");

	}/*
		 * should the turn method make sure that the player input actually did something
		 * to progress the game?
		 */
	/*
	 * keep working on turn. if keeps jumping 1. it is adding a bunch of numbers no
	 * matter if i get it right or not
	 */
	/*
	 * it is counting sequentially. it can't tell if the current player got it right
	 * or not. need to make it check if something in the word has changed and
	 * compare it to an old version of itself so it knows whether or not to switch
	 * to the next player
	 */

	/*
	 * turn method is still giving problems. the returned value isn't being used in
	 * the method. i can't figure out how this is messed up
	 */

	public static void turn(String s) {

		int letterMultiplier = 0;
		for (int i = 0; i < billboard.size(); i++) {

			if (s.toUpperCase().equals(billboard.get(i))) {

				letterMultiplier++;
				billboard.set(i, " ");
				System.out.println("correct");

			}
			if (letterMultiplier == 0) {
				playerturn++;
				break;
			}
			System.out.println(playerturn + " this is playerturn");
		}
		System.out.println(letterMultiplier + " this is lettermultiplier");
		System.out.println(billboard.toString());
		/*
		 * this might run after the boardchanger method and anything else to make it so
		 * it picks another player by adjusting the playerturn number.
		 */

		if (playerturn > 2) {
			playerturn = 0;
		}
		System.out.println(playerturn + " this is the playerturn counter");
	}

	/*
	 * method to make sure that the puzzle is solved. the puzle might be completed
	 * if someone guesses the whole word out so have to try to fix that.
	 */
	public static boolean isSolved(ArrayList<String> correctString, StringBuilder s2) {
		boolean correct = false;
		if (correctString.toString().equals(s2.toString())) {
			correct = true;
		}
		return correct;
	}

}
