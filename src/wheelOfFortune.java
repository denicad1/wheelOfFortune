import java.util.ArrayList;

/**
 * 
 */
/**
 * @author Anthony Denicolo
 *
 */
public class wheelOfFortune extends Setup {
	/*
	 * this counter is only for saying which player is getting named
	 */
	static int counter = 1;
	static int rounds = 3;
	/* array of players */
	public static ArrayList<player> listOfPlayers = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		turn();

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
	public static String choices(int i) {
		/*
		 * this for loop is for choosing which player is getting to choose what they
		 * want to do
		 */

		System.out.println("what would you like to do " + listOfPlayers.get(i).getName() + "? Press 1 to buy a vowel, "
				+ "press 2 to get a consonant " + "press 3 to solve the puzzle ");
		int caseNumber = key.nextInt();

		switch (caseNumber) {
		case 1: {
			return listOfPlayers.get(i).chooseVowel();

		}
		case 2: {
			return listOfPlayers.get(i).chooseConsonant();

		}
		case 3: {
			return listOfPlayers.get(i).solve();

		}
		}
		return null;

	}

	public static void turn() {
		ArrayList<String> temp2 = temp;

		do {
			spin();
			for (int j = 0; j < listOfPlayers.size(); j++) {

				System.out.println(spin());
				boardchanger(choices(j));

				if (j == 2) {
					j = 0;
				}
			}

		} while (temp2 != temp

		);
	}

	public static void boardchanger(String x) {

		for (int i = 0; i < temp.size(); i++) {
			if (billboard.get(i).equals(x)) {

				word.replace(i, i, x);

			}

		}
		System.out.println(word);

	}
}
